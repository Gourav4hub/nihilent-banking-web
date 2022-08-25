import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public userService:UserService,private router:Router) { }

  ngOnInit(): void {
  }

  public logout()
  {
    this.userService.logout()
    this.router.navigateByUrl("/")
  }

}
