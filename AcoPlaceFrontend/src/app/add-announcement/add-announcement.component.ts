import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { Announcement } from '../model/announcement';

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
      console.log(data);
      this.goToAnnouncementList;
    }, error=> console.log(error))
    
  }

  goToAnnouncementList(){
    this.router.navigate(['announcements-list'])
  }

  onSubmit(){
    console.log("THIS ANNOUNCEMENT"+this.announcement);
    this.saveAnnouncement();
  }
}
