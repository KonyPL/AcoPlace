import { Component, OnInit } from '@angular/core';
import { UserDetails } from '../model/user-details';
import { UserService } from '../sidebar/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userDetails: UserDetails;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUserDetails();
  }



  public getUserDetails(){
    this.userService.getCurrentUserDetails().subscribe(
      data => {
        this.userDetails = data;
        console.log("DATA from endpoint" + data);
      }
    )  }
}
