import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { Image } from '../model/image';
import { NgxGalleryOptions } from '@kolkov/ngx-gallery';
import { NgxGalleryImage } from '@kolkov/ngx-gallery';
import { NgxGalleryAnimation } from '@kolkov/ngx-gallery';
@Component({
  selector: 'app-banner-gallery',
  templateUrl: './banner-gallery.component.html',
  styleUrls: ['./banner-gallery.component.css']
})
export class BannerGalleryComponent implements OnInit {

  galleryOptions: NgxGalleryOptions[];
  galleryImages: NgxGalleryImage[];
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

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: false,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 4
      }
    },
    nav: true
  }

  slides: any = [[]];

  constructor() { }

  ngOnInit() {
    this.galleryOptions = [
      {
        //banner tak mozna
        // 'previewCloseOnEsc': true,
        // 'previewKeyboardNavigation': true,
        // 'imageBullets': true,
        // 'imageAutoPlay': true,
        // thumbnailsArrows: true,
        thumbnailsArrows: true,
        width: '600px',
        height: '400px',
        thumbnailsColumns: 4,
        arrowPrevIcon: 'fa fa-chevron-left',
        arrowNextIcon: 'fa fa-chevron-right',
        imageAnimation: NgxGalleryAnimation.Slide
      },
      // max-width 800
      {
        breakpoint: 800,
        width: '100%',
        height: '600px',
        imagePercent: 80,
        thumbnailsPercent: 20,
        thumbnailsMargin: 20,
        thumbnailMargin: 20,
        thumbnailsArrows: true,
        thumbnailsSwipe: true,
        imageBullets: true,
        // arrowPrevIcon: fa fa-arrow-circle-o-left,


      },
      // max-width 400
      {
        breakpoint: 400,
        preview: false
      }
    ];

    this.galleryImages = [
      {
        small: 'assets/images/photo1.png',
        medium: 'assets/images/photo1.png',
        big: 'assets/images/photo1.png'
      },
      {
        small: 'assets/images/photo2.png',
        medium: 'assets/images/photo2.png',
        big: 'assets/images/photo2.png'
      },
      {
        small: 'assets/images/photo3.png',
        medium: 'assets/images/photo3.png',
        big: 'assets/images/photo3.png'
      },
      {
        small: 'assets/images/photo1.png',
        medium: 'assets/images/photo1.png',
        big: 'assets/images/photo1.png'
      },
      {
        small: 'assets/images/photo2.png',
        medium: 'assets/images/photo2.png',
        big: 'assets/images/photo2.png'
      }, {
        small: 'assets/images/photo3.png',
        medium: 'assets/images/photo3.png',
        big: 'assets/images/photo3.png'
      },
      {
        small: 'assets/images/photo1.png',
        medium: 'assets/images/photo1.png',
        big: 'assets/images/photo1.png'
      }
    ];
  }

}

