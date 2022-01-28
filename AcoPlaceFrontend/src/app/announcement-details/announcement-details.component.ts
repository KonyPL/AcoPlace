import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AuthService } from '../auth/auth.service';
import { Announcement } from '../model/announcement';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
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
    });
    this.getAnnouncement();
    this.getUserDetails();


  }


  public getAnnouncement() {
    this.announcementService.getAnnouncementById(this.id).subscribe(
      data => {
        this.announcement = data;
        console.log("DATA from endpoint get announcement" + data);
      }
    )
  }



  editAnnouncement() {
    this.router.navigate(['announcementEdit', this.id]);
  }



  addToFavourite() {
    console.log("ID FROMA ANNOUNCEMENT=" + this.announcement.id);
    console.log("ID FROMA path=" + this.id);

    this.announcementService.addAnnouncementToFavourite(this.announcement.id).subscribe(
      data => {
        console.log("data from add to favourite" + data);
      }
    )

  }

  public getUserDetails() {
    this.userService.getCurrentUserProfileDtoByAnnouncementId(this.id).subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }


  public goToUserProfile() {
    this.router.navigate(['allUserInfo', this.id]);
  }

  public goToThisUserProfile() {
    this.router.navigate(['allUserInfo', this.id]);
  }


}
