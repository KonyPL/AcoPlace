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
    throw new Error('Method not implemented.');
  }

  // images: Image[] = [
  //   new Image('A Test Recipe', 'https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg'),
  // ]

  //   // imageObject: Array<object> = [{
  //   //   image: 'src/image/home1.jpg',
  //   //   thumbImage: '/src/image/home1.jpeg',
  //   //   alt: 'alt of image',
  //   //   title: 'title of image'
  //   // }]

  // title = 'newsmart';
  // public myImage: string = "app/images/home1.jpg";




}
