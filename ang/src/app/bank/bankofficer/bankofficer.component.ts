import { Component, OnInit } from '@angular/core';
import { BankService } from 'src/app/services/bank.service';
import { BankofficerService } from 'src/app/services/bankofficer.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-bankofficer',
  templateUrl: './bankofficer.component.html',
  styleUrls: ['./bankofficer.component.css']
})
export class BankofficerComponent implements OnInit 
{
  public errormsg:string = ""
  public banks:any[] = []
  public officers:any[] = []

  constructor(private bankService:BankService,
    private officerService:BankofficerService,private userService:UserService) { }

  ngOnInit(): void {   
    this.bankService.listBanks().subscribe((response:any)=>{
      console.log(response.data)
      this.banks = response.data
    })
    this.officerService.listBankOfficers().subscribe((response:any)=>{
      console.log(response.data)
      this.officers = response.data
    })
  }

  public save(data:any){  
    console.log(this.userService.userName() )
    data.loginOfficer = this.userService.userName() 
    this.officerService.saveBankOfficer(data).subscribe((response:any)=>{
      if(response.status){
        this.officers.push(response.data)
      }   
    })
  }

}
