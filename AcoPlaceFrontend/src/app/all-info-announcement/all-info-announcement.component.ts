import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';

@Component({
  selector: 'app-all-info-announcement',
  templateUrl: './all-info-announcement.component.html',
  styleUrls: ['./all-info-announcement.component.css']
})
export class AllInfoAnnouncementComponent implements OnInit {

  announcement: Announcement;
  id: number;
  constructor(private announcementService: AnnouncementService, private router: Router, private route: ActivatedRoute ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params)=> {
      this.id=+params['id'];
    });
    this.getAnnouncement();

  }

  public getAnnouncement(){
    this.announcementService.getAnnouncementById(this.id).subscribe(
      data => {
        this.announcement = data;
        console.log("DATA from endpoint" + data);
      }
    )  }

  
    addToFavourite(){
      console.log("ID FROMA ANNOUNCEMENT="+this.announcement.id);
      console.log("ID FROMA path="+this.id);

     this.announcementService.addAnnouncementToFavourite( this.announcement.id).subscribe(
       data => {
         console.log("data from add to favourite"+data);
       }
     )

    }
 
    editAnnouncement(){
      this.router.navigate(['announcementEdit', this.id]);
    }


    addImages() {
      console.log("ID FROM ANNOUCEMENT CREATE DTO " + this.id)
      this.router.navigate(['addImages', this.id]);
    }
}
