import { Component, Input, OnInit } from '@angular/core';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AnnouncementDetails } from '../model/announcement-details';

@Component({
  selector: 'app-announcement-details-details',
  templateUrl: './announcement-details-details.component.html',
  styleUrls: ['./announcement-details-details.component.css']
})
export class AnnouncementDetailsDetailsComponent implements OnInit {

  @Input('id') id: number; 
  announcementDetails: AnnouncementDetails;
  constructor(private announcementService: AnnouncementService) { }

  ngOnInit(): void {
    this.getAnnouncementDetails();
  
  }


  public getAnnouncementDetails(){
    this.announcementService.getAnnouncementDetailsById(this.id).subscribe(
      data => {
        this.announcementDetails = data;
        console.log("DATA from endpoint" + data);
      }
    )  }

}
