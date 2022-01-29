import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Announcement } from '../model/announcement';
import { AnnouncementService } from './announcement.service';
import { MatTableModule } from '@angular/material/table';
import { SearchAnnouncementComponent } from '../search-announcement/search-announcement.component';
import { AnnouncementParams } from '../model/announcementParams';
import { ThemePalette } from '@angular/material/core';
import { ImageUploadService } from '../file-base64/image-upload.service';
import { ImageStorage } from '../model/image-storage';

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

  constructor(private announcementService: AnnouncementService, private router: Router, private imageUploadService: ImageUploadService) { }
  
  ngOnInit(): void {
    this.getAnnouncements();
    // this.getImage
  }

  getImage(announcement_id: number): any {
    this.imageUploadService.getImage(announcement_id).subscribe(
      data => {
        console.log("get image w announcement list component " + data);
        return data;
      }
    )
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
    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
      data => {
        this.announcements = data;

        console.log("DATA from endpoint" + data);
      }
    )
  }

  
}
