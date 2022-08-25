import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  public customer:any = {}
  public transactions:any=[]
  constructor(private userService:UserService,
    private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomer(this.userService.userName()).subscribe((response:any)=>{
      if(response.status)
      {
        console.log("Customer : " , response)
        this.customer = response.data

        this.customerService.getTransactions(this.userService.userName()).subscribe((response:any)=>{
          console.log("TR : " , response)
          if(response.status)
           this.transactions = response.data
        });
      }
      else 
        alert("Something Wrong : " + response.msg)  
    })
  }

}
