import { Component, OnInit } from '@angular/core';
import { ActtypeService } from 'src/app/services/acttype.service';

@Component({
  selector: 'app-accounttype',
  templateUrl: './accounttype.component.html',
  styleUrls: ['./accounttype.component.css']
})
export class AccounttypeComponent implements OnInit 
{
  public errormsg:string = ""
  public types:any[] = []
  constructor(private actTypesService:ActtypeService) { }

  ngOnInit(): void {
    this.actTypesService.listTypes().subscribe((response:any)=>{
      this.types = response.data
    })
  }

  public save(data:any){
    this.actTypesService.saveType(data).subscribe((response:any)=>{
      if(response.status){
        this.types.push(response.data)
      }
    })
  }

}
