import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { ActtypeService } from 'src/app/services/acttype.service';
import { CustomeraccountService } from 'src/app/services/customeraccount.service';
@Component({
  selector: 'app-customeraccount',
  templateUrl: './customeraccount.component.html',
  styleUrls: ['./customeraccount.component.css']
})
export class CustomeraccountComponent implements OnInit {
  private id:any = 0;
  
  public errormsg:string = ""  
  public types:any[] = []
  constructor(private route: ActivatedRoute,
    private actTypesService:ActtypeService,private accountService:CustomeraccountService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id')
    console.log("IDDDD : ",this.id)
    this.actTypesService.listTypes().subscribe((response:any)=>{
      this.types = response.data
    })
  }

  public save(data:any){
    data.customer = this.id
    this.accountService.saveAccount(data).subscribe((response:any)=>{
      
       this.errormsg = response.msg
    })
  }

}
