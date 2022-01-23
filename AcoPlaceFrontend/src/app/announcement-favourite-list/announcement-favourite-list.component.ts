import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';

@Component({
  selector: 'app-announcement-favourite-list',
  templateUrl: './announcement-favourite-list.component.html',
  styleUrls: ['./announcement-favourite-list.component.css']
})
export class AnnouncementFavouriteListComponent implements OnInit {

   
  announcements: Announcement[];

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncementsFavouriteList();
  }


  private getAnnouncementsFavouriteList() {
    this.announcementService.getFavouriteAnnouncementsList().subscribe(
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
