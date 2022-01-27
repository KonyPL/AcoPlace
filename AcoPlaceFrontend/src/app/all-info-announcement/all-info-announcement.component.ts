import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AuthService } from '../auth/auth.service';
import { Announcement } from '../model/announcement';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service'
@Component({
  selector: 'app-all-info-announcement',
  templateUrl: './all-info-announcement.component.html',
  styleUrls: ['./all-info-announcement.component.css']
})
export class AllInfoAnnouncementComponent implements OnInit {
  userProfileDto: UserProfileDto;
  announcement: Announcement;
  id: number;
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
        console.log("DATA from endpoint" + data);
      }
    )
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

  editAnnouncement() {
    this.router.navigate(['announcementEdit', this.id]);
  }


  addImages() {
    console.log("ID FROM ANNOUCEMENT CREATE DTO " + this.id)
    this.router.navigate(['addImages', this.id]);
  }

  public goToUserProfile() {
    this.router.navigate(['allUserInfo', this.id]);
  }

  public getUserDetails() {
    this.userService.getCurrentUserProfileDtoByAnnouncementId(this.id).subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }
}
