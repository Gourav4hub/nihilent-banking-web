import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  public errormsg:string = ""
  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  public login(data:any){
    this.userService.login(data).subscribe((response:any)=>{
      console.log(response)
       if(response.status){
          this.userService.setLoginUser(response.data)
       }else{
          this.errormsg = response.msg
       }
    })
  }

}
