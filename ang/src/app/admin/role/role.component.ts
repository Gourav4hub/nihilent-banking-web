import { Component, OnInit } from '@angular/core';
import { RoleService } from 'src/app/services/role.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit 
{
  public errormsg:string = ""
  public roles:any[] = []
  constructor(private roleService:RoleService) { }

  ngOnInit(): void {
    this.roleService.listRoles().subscribe((response:any)=>{
      this.roles = response.data
    })
  }

  public save(data:any){
    this.roleService.saveRole(data).subscribe((response:any)=>{
      if(response.status){
        this.roles.push(response.data)
      }
    })
  }
}
