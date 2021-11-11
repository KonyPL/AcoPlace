import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Announcement } from '../model/announcement';
import { AnnouncementService } from './announcement.service';

@Component({
  selector: 'app-announcement-list',
  templateUrl: './announcement-list.component.html',
  styleUrls: ['./announcement-list.component.css']
})
export class AnnouncementListComponent implements OnInit {

  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService, private router: Router) { }

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

  public showAnnouncementById(id: number){
    console.log("odczytuje id="+id);
    this.router.navigate(['announcement', id]);

  }

  /* 
    employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
  }

  */
}
