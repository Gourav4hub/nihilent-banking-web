import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService 
{
  private loginUser:any = {
    username : undefined,
    loginstatus : false,
    usertype : undefined,
    token : undefined
  }
  constructor(private http:HttpClient) { 
    var info = localStorage.getItem('user')
    if(info!=null){
      this.loginUser = JSON.parse(info)
      console.log(">>>>" , this.loginUser)
    }
  }

  public isLogin(){return this.loginUser.loginstatus}
  public userName(){return this.loginUser.username}
  public userType(){return this.loginUser.usertype}
  public userToken(){return this.loginUser.token}

  public setLoginUser(data:any){
    console.log(">>>>>",data)
    this.loginUser.username = data.username
    this.loginUser.usertype = data.usertype
    this.loginUser.token = data.token
    this.loginUser.loginstatus = true

    localStorage.setItem('user',JSON.stringify(this.loginUser))
  }

  public logout(){
    this.loginUser.username = undefined
    this.loginUser.usertype = undefined
    this.loginUser.token = undefined
    this.loginUser.loginstatus = false
    localStorage.removeItem('user')
  }

  public login(data:any){
      return this.http.post("/api/authenticate",data)
  }

  public listUsers()
  {
    return this.http.get("/api/user/list")
  }
}
