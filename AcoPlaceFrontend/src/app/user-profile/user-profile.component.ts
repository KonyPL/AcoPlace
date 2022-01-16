import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserPrefereces } from '../model/user-preferences';
import { UserTable } from '../model/user-table';
import { UserService } from './user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  user: User[];
  userPrederences: UserPrefereces = new UserPrefereces();
  userTable: UserTable = new UserTable();

  constructor(private userService: UserService, private router: Router) { }

}
