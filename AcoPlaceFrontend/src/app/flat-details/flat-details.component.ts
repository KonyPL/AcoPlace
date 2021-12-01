import { Component, Input, OnInit } from '@angular/core';
import { HouseService } from '../house-details/house.service';
import { FlatDetails } from '../model/flat-details';
import { HouseDetails } from '../model/house-details';
import { FlatService } from './flat.service';

@Component({
  selector: 'app-flat-details',
  templateUrl: './flat-details.component.html',
  styleUrls: ['./flat-details.component.css']
})
export class FlatDetailsComponent implements OnInit {

  @Input('id') id: number; 
  flatDetails: FlatDetails;

  constructor(private flatService: FlatService) { }

  ngOnInit(): void {
    this.getFlatDetails();
  }



  public getFlatDetails(){
    this.flatService.getFlatByAnnouncementId(this.id).subscribe(
      data => {
        this.flatDetails = data;
        console.log("DATA from endpoint" + data);
      }
    )  }

}
