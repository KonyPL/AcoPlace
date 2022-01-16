import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Announcement } from '../model/announcement';
import { AnnouncementService } from './announcement.service';
import { MatTableModule } from '@angular/material/table';
import { SearchAnnouncementComponent } from '../search-announcement/search-announcement.component';
import { AnnouncementParams } from '../model/announcementParams';
import { ThemePalette } from '@angular/material/core';

export interface Task {
  name: string;
  completed: boolean;
  color: ThemePalette;
  subtasks?: Task[];
}

@Component({
  selector: 'app-announcement-list',
  templateUrl: './announcement-list.component.html',
  styleUrls: ['./announcement-list.component.css']
})
export class AnnouncementListComponent implements OnInit {

  shower: boolean = false;


  announcementParams: AnnouncementParams = new AnnouncementParams();

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

    this.announcementParams.shower = this.shower ? "true" : "false";

    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
      data => {
        this.announcements = data;

        console.log("DATA from endpoint" + data);
      }
    )
  }
}
