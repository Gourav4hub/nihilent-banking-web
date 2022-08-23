import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import {Router} from '@angular/router'; 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  public errormsg:string = ""
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    if(this.userService.isLogin())
      this.router.navigateByUrl("/home")
  }

  public login(data:any){
    this.userService.login(data).subscribe((response:any)=>{
      console.log(response)
       if(response.status){
          this.userService.setLoginUser(response.data)
          this.router.navigateByUrl("/home")
       }else{
          this.errormsg = response.msg
       }
    })
  }

}
