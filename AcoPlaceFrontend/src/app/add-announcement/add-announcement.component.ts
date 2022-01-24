import { Component, OnInit } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
import { AnnouncementCreateDto } from '../model/announcement-dto';
//import { MatSliderModule } from '@angular/material/slider';

@Component({
  selector: 'app-add-announcement',
  templateUrl: './add-announcement.component.html',
  styleUrls: ['./add-announcement.component.css']
})
export class AddAnnouncementComponent implements OnInit {
  announcementDto: AnnouncementCreateDto = new AnnouncementCreateDto();
  announcementId: number;


  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
  }

//TU DUZO DO ZMIANY JESZCE 
  
onSubmit(){
  console.log("THIS ANNOUNCEMENT on sumbit clicked"+this.announcementDto);

 this.saveAnnouncement();
}


 /* goToAnnouncementList() {
    console.log("jestem w  go to tu chce byc announcement list");
    this.router.navigate(['announcements-list']);
  }*/


saveAnnouncement(){
    this.announcementService.createAnnouncementByDto(this.announcementDto).subscribe(
      data => {
        this.announcementId= data.id;
        console.log("JESTEM E SAVE ANNOUNCEMENTdata id="+data.id);

      }
    );
    console.log("JESTEM E SAVE ANNOUNCEMENT");

   this.addImages();

    }


    addImages(){
      console.log("ID FROM ANNOUCEMENT CREATE DTO "+this.announcementId)
      this.router.navigate(['addImages', this.announcementDto.id]);
    }
    /*  
    data => {
        this.announcementsDetailsList = data;
        console.log("DATA from endpoint" + data);
      }
    */

}




