import { FactoryTarget } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { AnnouncementParams } from '../model/announcementParams';
import { MatTableModule } from '@angular/material/table';

interface TrueFalse {
  value: boolean;
  viewValue: boolean;
}

export interface Task {
  name: string;
  completed: boolean;
  // color: ThemePalette;
  subtasks?: Task[];
}

@Component({
  selector: 'app-search-announcement',
  templateUrl: './search-announcement.component.html',
  styleUrls: ['./search-announcement.component.css']
})
export class SearchAnnouncementComponent implements OnInit {
  // checked = false;


  trueFalse: TrueFalse[] = [
    { value: true, viewValue: true },
    { value: false, viewValue: false },
  ];

  announcementParams: AnnouncementParams = new AnnouncementParams();
  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
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
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.propertyType);

    //this.announcementService.getAnnouncementWithParams(this.announcementParams);
    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
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
