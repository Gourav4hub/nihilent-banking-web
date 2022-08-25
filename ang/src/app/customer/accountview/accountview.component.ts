import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-accountview',
  templateUrl: './accountview.component.html',
  styleUrls: ['./accountview.component.css']
})
export class AccountviewComponent implements OnInit {

  public accountData:any = {}
  constructor(private userService:UserService,private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomer(this.userService.userName()).subscribe((response:any)=>{
      if(response.status)
        this.accountData = response.data.account 
      else 
        alert("Something Wrong : " + response.msg)  
    })
  }

}
