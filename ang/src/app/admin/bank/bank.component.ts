import { Component, OnInit } from '@angular/core';
import { ActtypeService } from 'src/app/services/acttype.service';
import { BankService } from 'src/app/services/bank.service';

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit 
{
  public errormsg:string = ""
  public banks:any[] = []
  public types:any[] = []

  public selectedTypes:any[] = []
  constructor(private bankService:BankService,private actTypesService:ActtypeService) { }

  ngOnInit(): void {
    this.actTypesService.listTypes().subscribe((response:any)=>{
      this.types = response.data
    })
    this.bankService.listBanks().subscribe((response:any)=>{
      this.banks = response.data
    })
  }

  public changeType(evt:any){
    var cmp = evt.target;
    console.log(cmp , cmp.value, cmp.checked)
    if(cmp.checked)
      this.selectedTypes.push(cmp.value*1)
    else
      this.selectedTypes= this.selectedTypes.filter(val=>val==cmp.value)
  }

  public save(data:any){
    //console.log(data)
    //console.log(this.selectedTypes)
    data.types = this.selectedTypes
    this.bankService.saveBank(data).subscribe((response:any)=>{
      if(response.status){
        this.banks.push(response.data)
      }
      this.selectedTypes=[]
    })
  }

}
