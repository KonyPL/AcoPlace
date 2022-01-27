import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';

@Component({
  selector: 'app-announcement-inactive-list',
  templateUrl: './announcement-inactive-list.component.html',
  styleUrls: ['./announcement-inactive-list.component.css']
})
export class AnnouncementInactiveListComponent implements OnInit {

  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncementsInactiveList();
  }


  private getAnnouncementsInactiveList() {
    this.announcementService.getInactiveAnnouncementsList().subscribe(
      data => {
        this.announcements = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }



  public showAnnouncementById(id: number) {
    console.log("odczytuje id=" + id);
    this.router.navigate(['allAnnouncement', id]);

  }
}
