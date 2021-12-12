import { Component, OnInit } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';
//import { MatSliderModule } from '@angular/material/slider';

@Component({
  selector: 'app-add-announcement',
  templateUrl: './add-announcement.component.html',
  styleUrls: ['./add-announcement.component.css']
})
export class AddAnnouncementComponent implements OnInit {
  announcement: Announcement = new Announcement();

  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
  }

  

  saveAnnouncement(){
    this.announcementService.createAnnouncement(this.announcement).subscribe( data =>{
      console.log("jestem w save announcement"+data);
      this.goToAnnouncementList();
    }, error=> console.log(error))
    
  }

  goToAnnouncementList(){
    console.log("jestem w  go to tu chce byc announcement list");
    this.router.navigate(['announcements-list']);
  }

  onSubmit(){
    console.log("THIS ANNOUNCEMENT on sumbit clicked"+this.announcement);
    this.saveAnnouncement();
  }
}
