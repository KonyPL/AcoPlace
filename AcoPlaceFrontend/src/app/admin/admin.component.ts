import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  announcementParams: AnnouncementParams = new AnnouncementParams();

  announcements: Announcement[];
  // dataSource = new MatTableModule();




  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncements();
    // this.getCheckboxes();
  }

  private getAnnouncements() {
    this.announcementService.getAnnouncementsList().subscribe(
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


  onSubmit() {
    console.log("THIS ANNOUNCEMENT on sumbit clicked" + this.announcementParams);
    this.searchAnnouncement();
  }



  searchAnnouncement() {

    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.oven);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.priceMax);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.priceMin);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.shower);
    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
      data => {
        this.announcements = data;

        console.log("DATA from endpoint" + data);
      }
    )
  }
}
