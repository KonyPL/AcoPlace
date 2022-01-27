import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { HeaderComponent } from '../header/header.component';
@Component({
  selector: 'app-announcement-details',
  templateUrl: './announcement-details.component.html',
  styleUrls: ['./announcement-details.component.css']
})
export class AnnouncementDetailsComponent implements OnInit {//TODO ZMIANA NAZWY POTRZEBNA
  announcement: Announcement;
  id: number;
  constructor(private announcementService: AnnouncementService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
    });
    this.getAnnouncement();

  }


  public getAnnouncement() {
    this.announcementService.getAnnouncementById(this.id).subscribe(
      data => {
        this.announcement = data;
        console.log("DATA from endpoint get announcement" + data);
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
}
