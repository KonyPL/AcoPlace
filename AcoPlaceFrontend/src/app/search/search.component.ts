import { Component, OnInit } from '@angular/core';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AnnouncementParams } from '../model/announcementParams';
import { AnnouncementDetails } from '../model/announcement-details';
import { Announcement } from '../model/announcement';
import { SearchService } from './search.service';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  dataSource: MatTableDataSource<Announcement>;
  // posts: Announcement[];
  columns: string[] = ['id', 'country', 'city'];
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

    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
      data => {
        this.announcements = data;

        console.log("DATA from endpoint" + data);
      }
    )
  }
}