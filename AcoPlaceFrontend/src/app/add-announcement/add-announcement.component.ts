import { Component, OnInit } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { AnnouncementCreateDto } from '../model/announcement-dto';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { MatButton } from '@angular/material/button';
import { MatSliderModule } from '@angular/material/slider';
// MatButton
declare var $: any;
@Component({
  selector: 'app-add-announcement',
  templateUrl: './add-announcement.component.html',
  styleUrls: ['./add-announcement.component.css']
})
export class AddAnnouncementComponent implements OnInit {
  announcementDto: AnnouncementCreateDto = new AnnouncementCreateDto();
  announcementId: number;

  model: NgbDateStruct;

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
  }

  //TU DUZO DO ZMIANY JESZCE 

  onSubmit() {
    console.log("THIS ANNOUNCEMENT on sumbit clicked" + this.announcementDto);

    this.saveAnnouncement();
  }


  /* goToAnnouncementList() {
     console.log("jestem w  go to tu chce byc announcement list");
     this.router.navigate(['announcements-list']);
   }*/


  saveAnnouncement() {
    this.announcementService.createAnnouncementByDto(this.announcementDto).subscribe(
      data => {
        this.announcementId = data;
        console.log("dane po zwrocie  zposta id=" + data);
        this.addImages();

      }
    );
    console.log("JESTEM w SAVE ANNOUNCEMENT");



  }


  addImages() {
    console.log("ID FROM ANNOUCEMENT CREATE DTO " + this.announcementId)
    this.router.navigate(['addImages', this.announcementId]);
  }
  /*  
  data => {
      this.announcementsDetailsList = data;
      console.log("DATA from endpoint" + data);
    }
  */

}




