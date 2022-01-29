import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service';

@Component({
  selector: 'app-other-user-profile',
  templateUrl: './other-user-profile.component.html',
  styleUrls: ['./other-user-profile.component.css']
})
export class OtherUserProfileComponent implements OnInit {

  userProfileDto: UserProfileDto;
  id: number;
  announcements: Announcement[];

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute, private announcementService: AnnouncementService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
    });
    this.getUserDetails();
    this.getAnnouncementsList();
  }


  public getUserDetails() {
    this.userService.getCurrentUserProfileDtoByAnnouncementId(this.id).subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }



  private getAnnouncementsList() {
    this.announcementService.getActiveAnnouncementsListById(this.id).subscribe( // tu zmiany bo to nie ta metoda
      data => {
        this.announcements = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }



  public showAnnouncementById(id: number) {
    console.log("odczytuje id=" + id);
    this.router.navigate(['announcement', id]);

  }

  public goToUserProfile() {
    this.router.navigate(['allUserInfo', this.id]);
  }
}
