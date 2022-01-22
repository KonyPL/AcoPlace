import { Component, OnInit } from '@angular/core';
import { Image } from '../model/image';


@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.css']
})
export class StartPageComponent implements OnInit {
  constructor() { }
  ngOnInit(): void {
    
  }

  public images: Image[] = [
    {
      url: 'assets/images/Poznan_logo.png',
      id: '1',
      // row: '3/3'
    },
    {
      url: 'assets/images/photo1.png',
      id: '2',
      // row: '3/3'
    },
    {
      url: 'assets/images/photo2.png',
      id: '3',
      // row: '3/3'
    },
    {
      url: 'assets/images/photo3.png',
      id: '4',
      // row: '3/3'
    },
  ] as Array<Image>;

}
