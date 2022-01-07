import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { AnnouncementDetails } from '../model/announcement-details';
import { AnnouncementDetailsService } from './announcement-details.service';

@Component({
  selector: 'app-announcement-details-list',
  templateUrl: './announcement-details-list.component.html',
  styleUrls: ['./announcement-details-list.component.css']
})
export class AnnouncementDetailsListComponent implements OnInit {

  announcementsDetailsList: AnnouncementDetails[];

  constructor(private announcementDetailsService: AnnouncementDetailsService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncementsDetailsList();
  }

  private getAnnouncementsDetailsList() {
    this.announcementDetailsService.getAnnouncementsDetailsList().subscribe(
      data => {
        this.announcementsDetailsList = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }

  public showAnnouncementDetailsById(id: number) {
    console.log("odczytuje id=" + id);
    this.router.navigate(['announcementDetails', id]);

  }


}
