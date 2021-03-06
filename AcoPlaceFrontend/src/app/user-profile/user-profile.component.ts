import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../model/user-details';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userProfileDto: UserProfileDto;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getUserDetails();
  }



  public getUserDetails(){
    this.userService.getCurrentUserProfileDto().subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint" + data);
      }
    )  }


    editUser(){
      this.router.navigate(['userEdit']);
    }

}
