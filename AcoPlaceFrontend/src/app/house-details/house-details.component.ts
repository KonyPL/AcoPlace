import { Component, Input, OnInit } from '@angular/core';
import { HouseDetails } from '../model/house-details';
import { HouseService } from './house.service';

@Component({
  selector: 'app-house-details',
  templateUrl: './house-details.component.html',
  styleUrls: ['./house-details.component.css']
})
export class HouseDetailsComponent implements OnInit {

  @Input('id') id: number; 
  houseDetails: HouseDetails;

  constructor(private houseService: HouseService) { }

  ngOnInit(): void {
    this.getHouseDetails();
  }



  public getHouseDetails(){
    this.houseService.getHouseByAnnouncementId(this.id).subscribe(
      data => {
        this.houseDetails = data;
        console.log("DATA from endpoint" + data);
      }
    )  }

}
