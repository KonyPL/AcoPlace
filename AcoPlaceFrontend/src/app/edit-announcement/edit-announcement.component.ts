import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AnnouncementService } from '../announcement-list/announcement.service';
import { AnnouncementCreateDto } from '../model/announcement-dto';

@Component({
  selector: 'app-edit-announcement',
  templateUrl: './edit-announcement.component.html',
  styleUrls: ['./edit-announcement.component.css']
})
export class EditAnnouncementComponent implements OnInit {

  announcementDto: AnnouncementCreateDto = new AnnouncementCreateDto();
  id: number;
  constructor(private announcementService: AnnouncementService, private router: Router, private route: ActivatedRoute) { }
  //musimy miec id skad je wziac? 

  ngOnInit(): void {
    this.route.params.subscribe((params: Params)=> {
      this.id=+params['id'];
    });
    this.getAnnouncementDto();

  }

  public getAnnouncementDto(){
    this.announcementService.getAnnouncementCreateDtoById(this.id).subscribe(
      data => {
        this.announcementDto = data;
        console.log("DATA from endpoint" + data);
      }
    )  }
//TU DUZO DO ZMIANY JESZCE 
  
onSubmitEdit(){
  console.log("THIS ANNOUNCEMENT on sumbit edited clicked"+this.announcementDto.id);

 this.updateAnnouncement();

}


  goToAnnouncementList() {
    console.log("jestem w  go to tu chce byc announcement list");
    this.router.navigate(['announcements-list']);
  }


updateAnnouncement(){ // save moze nie zadzaialac chyba trzeba napisac nowy endpoint 
    this.announcementService.updateAnnouncementByDto(this.announcementDto).subscribe();
    console.log("JESTEM W UPDARE ANNOCUEMENT ANNOUNCEMENT");
    this.goToAnnouncementList(); // mozna przekierowac gdzies indziej ale tak wstepnie 
    }

  

}
