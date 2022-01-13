import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Announcement } from '../model/announcement';
import { AnnouncementService } from './announcement.service';
import { MatTableModule } from '@angular/material/table';
import { SearchAnnouncementComponent } from '../search-announcement/search-announcement.component';
import { AnnouncementParams } from '../model/announcementParams';
import { ThemePalette } from '@angular/material/core';

export interface Task {
  name: string;
  completed: boolean;
  color: ThemePalette;
  subtasks?: Task[];
}

// class sideBar {
//   id: number;
//   name: string;
//   isSelected: boolean;
// }

@Component({
  selector: 'app-announcement-list',
  templateUrl: './announcement-list.component.html',
  styleUrls: ['./announcement-list.component.css']
})
export class AnnouncementListComponent implements OnInit {

  // _checkboxlist: sideBar[];

  // ngOnInit

  // getCheckboxes() {
  //   this._checkboxlist = [
  //     { id: 1, name: "Bath", isSelected: false },
  //     { id: 2, name: "Shower", isSelected: false },
  //     { id: 3, name: "Microvawe", isSelected: false },
  //     { id: 4, name: "Oven", isSelected: false },
  //     { id: 5, name: "Elevator", isSelected: false },
  //     { id: 6, name: "Internet", isSelected: false },
  //   ]
  // }

  // onChange() {
  //   console.log(this._checkboxlist);
  // }
  shower: boolean = false;


  announcementParams: AnnouncementParams = new AnnouncementParams();

  announcements: Announcement[];
  // dataSource = new MatTableModule();




  constructor(private announcementService: AnnouncementService, private router: Router) { }

  ngOnInit(): void {
    this.getAnnouncements();
    // this.getCheckboxes();
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




  /* 
    employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
  }

  */


  onSubmit() {
    console.log("THIS ANNOUNCEMENT on sumbit clicked" + this.announcementParams);
    this.searchAnnouncement();
  }



  searchAnnouncement() {

    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.oven);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.priceMax);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.priceMin);
    console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.shower);
    // console.log("THIS ANNOUNCEMENT search clicked" + this.announcementParams.propertyType);
    // this.announcementParams.bath = shower;
    this.announcementParams.shower = this.shower ? "true" : "false";
    // this.announcementParams.micr = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;
    // this.announcementParams.shower = shower;

    // id: number;
    // bath: boolean; 
    // shower: boolean; 
    // microwave: boolean; 
    // oven: boolean; 
    // petsAllowed: boolean; 
    // elevator: boolean; 
    // nearPark: boolean; 
    // fenced: boolean; 
    // nearTram: boolean; 
    // nearBus: boolean;
    // wifi: boolean; 
    // ethernetOutlets: boolean; 
    // internet: boolean;
    // internetSpeed: number;
    // tv: boolean; 
    // dishwasher: boolean;
    // clothesDryer: boolean;
    // nearShoppingMall: boolean;
    // nearBakery: boolean;
    // nearFoodMarket: boolean;
    // nearSupermarket: boolean; 

    //this.announcementService.getAnnouncementWithParams(this.announcementParams);
    this.announcementService.getAnnouncementWithParams(this.announcementParams).subscribe(
      data => {
        this.announcements = data;

        console.log("DATA from endpoint" + data);
      }
    )
  }
}
