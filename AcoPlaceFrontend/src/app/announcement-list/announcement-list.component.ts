import { Component, OnInit } from '@angular/core';
import { Announcement } from '../model/announcement';
import { AnnouncementService } from './announcement.service';

@Component({
  selector: 'app-announcement-list',
  templateUrl: './announcement-list.component.html',
  styleUrls: ['./announcement-list.component.css']
})
export class AnnouncementListComponent implements OnInit {

  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService) { }

  ngOnInit(): void {
    this.getAnnouncements();
  }

  private getAnnouncements() {
    this.announcementService.getAnnouncementsList().subscribe(
      data => {
        this.announcements = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }
}
