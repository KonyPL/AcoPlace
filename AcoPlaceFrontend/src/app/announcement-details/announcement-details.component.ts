import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AuthService } from '../auth/auth.service';
import { Announcement } from '../model/announcement';
import { Observable } from 'rxjs';
import { HeaderComponent } from '../header/header.component';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service';

@Component({
  selector: 'app-announcement-details',
  templateUrl: './announcement-details.component.html',
  styleUrls: ['./announcement-details.component.css']
})
export class AnnouncementDetailsComponent implements OnInit {//TODO ZMIANA NAZWY POTRZEBNA
  announcement: Announcement;
  id: number;

  userProfileDto: UserProfileDto;

  constructor(private announcementService: AnnouncementService, private router: Router, private route: ActivatedRoute, private userService: UserService, public authService: AuthService) { }


  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];

      this.getAnnouncement();
      this.getUserDetails();
    });
  }


  public getAnnouncement() {
    this.announcementService.getAnnouncementById(this.id).subscribe(
      data => {
        this.announcement = data;
      },
      error => {
        window.alert("Error: " + error);
      }
    )
  }

  addToFavourite() {
    this.announcementService.addAnnouncementToFavourite(this.announcement.id).subscribe(
      data => {
        if(data == null){
          window.alert("Annonuncement is already in Favorites!");
        } else {
          window.alert("Annonuncement successfully added to Favorites!");
        }
      },
      error => {
        window.alert("Error: " + error);
      }
    )

  }

  public getUserDetails() {
    this.userService.getCurrentUserProfileDtoByAnnouncementId(this.id).subscribe(
      data => {
        this.userProfileDto = data;
        //switch to AllInfo page for owner
        if(data.userName === this.authService.currentUserName()){
          this.router.navigate(['allAnnouncement', this.id]);
        }
      }
    )
  }

  public goToUserProfile() {
    this.router.navigate(['allUserInfo', this.id]);
  }
}
