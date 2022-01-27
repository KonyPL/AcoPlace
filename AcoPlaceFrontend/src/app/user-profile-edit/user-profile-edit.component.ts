import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service';

@Component({
  selector: 'app-user-profile-edit',
  templateUrl: './user-profile-edit.component.html',
  styleUrls: ['./user-profile-edit.component.css']
})
export class UserProfileEditComponent implements OnInit {

  userProfileDto: UserProfileDto;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getUserDetails();
  }


  public getUserDetails(){
    this.userService.getCurrentUserProfileDto().subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint about" + data.about);
        console.log("DATA from endpoint about" + data.countryCode);
        console.log("DATA from endpoint about" + data.email);
        console.log("DATA from endpoint about" + data.userName);
        console.log("DATA from endpoint about" + data.lastName);
        console.log("DATA from endpoint about" + data.firstName);


      }
    )  }


    goToUserProfile() {
      console.log("jestem w  go tp user profie");
      this.router.navigate(['user-profile']);
    }

    onEdit(){
      this.userService.updateUserByDto(this.userProfileDto).subscribe();
      this.goToUserProfile();

    }



}
