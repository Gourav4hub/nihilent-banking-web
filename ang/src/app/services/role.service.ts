import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class RoleService
{
  constructor(private http:HttpClient,private userService:UserService) { }

  public saveRole(data:any)
  {
    return this.http.post("/api/role/save",data)
  }

  public listRoles()
  {
    return this.http.get("/api/role/list")
  }
}
