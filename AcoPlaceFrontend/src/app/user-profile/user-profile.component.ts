import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserPrefereces } from '../model/user-preferences';
import { WebUser } from '../model/web-user';

import { UserService } from './user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private userService: UserService) { }

  webUser: WebUser;

  ngOnInit(): void {
    this.getUser();
  }


  public getUser(){
    this.userService.getUserInfo().subscribe(
      data => {
        this.webUser = data;
        console.log("DATA from endpoint" + data);
      }
    )  }


}
