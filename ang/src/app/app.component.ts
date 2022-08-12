import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent 
{
  public employees:any = []

  constructor(private http:HttpClient){}

  public load(){
    this.http.get("http://localhost:8182/employee/list")
    .subscribe((response:any)=>{
        this.employees = response.data
    });
  }

  public save(frmData:any)
  {
    this.http.post("http://localhost:8182/employee/save",frmData)
    .subscribe((response:any)=>{
        alert(response.msg)
    });
  }
}
