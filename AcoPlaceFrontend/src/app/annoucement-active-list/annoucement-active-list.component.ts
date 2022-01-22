import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';

@Component({
  selector: 'app-annoucement-active-list',
  templateUrl: './annoucement-active-list.component.html',
  styleUrls: ['./annoucement-active-list.component.css']
})
export class AnnoucementActiveListComponent implements OnInit {
  
  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncementsActiveList();
  }


  private getAnnouncementsActiveList() {
    this.announcementService.getActiveAnnouncementsList().subscribe(
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
}
