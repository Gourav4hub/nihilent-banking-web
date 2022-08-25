import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit 
{
  public upiFoundStatus:boolean = false
  public perTransLimitStatus:boolean = false

  public upiFoundMsg:string = ""
  public perTransLimitMsg:string = ""

  public errormsg:string = ""
 
  public accountData:any = {}
  constructor(private userService:UserService,
    private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomer(this.userService.userName()).subscribe((response:any)=>{
      if(response.status)
        this.accountData = response.data.account 
      else 
        alert("Something Wrong : " + response.msg)  
    })
  }

  public checkUPI(event:any)
  {
    var upi = event.target.value 
    
    if(upi.length==0)
      this.errormsg = "Please Fill UPI ID !"
    else
    {
      this.customerService.getCustomerByUpi(upi).subscribe((response:any)=>{
        this.upiFoundStatus = response.status
        if(response.status)
          this.upiFoundMsg = response.msg + " , Name : " + response.data.customerName
        else  
          this.upiFoundMsg = response.msg 
      });
    }  
  }

  public checkAmount(event:any)
  {
    var amount = parseFloat(event.target.value+"")
    if(amount>this.accountData.perTransactionLimit)
    {
      this.perTransLimitMsg = "Amount out of Limit !"
      this.perTransLimitStatus = false
    }else{
      this.perTransLimitMsg = ""
      this.perTransLimitStatus = true
    }
  }

  public send(data:any){
    data.username = this.userService.userName()
    this.customerService.sendAmount(data).subscribe((response:any)=>{
     this.upiFoundStatus=false
     this.perTransLimitStatus=false   
     this.upiFoundMsg= ""
     this.perTransLimitMsg= ""   
     this.errormsg= ""
     alert(response.msg)
    });
  }

}
