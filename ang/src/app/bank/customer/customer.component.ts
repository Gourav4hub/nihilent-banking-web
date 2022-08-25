import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  public errormsg:string = ""
  public customers:any[] = []
  constructor(private userService:UserService,
    private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.listCustomer().subscribe((response:any)=>{
      if(response.status)
        this.customers = response.data
    })
  }

  public save(data:any){  
    console.log(this.userService.userName() )
    data.officerId = this.userService.userName() 
    this.customerService.saveCustomer(data).subscribe((response:any)=>{
      if(response.status){
        this.customers.push(response.data)
      }   
    })
  }

}
