import { Component, OnInit } from '@angular/core';
import { NgxGalleryOptions } from '@kolkov/ngx-gallery';
import { NgxGalleryImage } from '@kolkov/ngx-gallery';
import { NgxGalleryAnimation } from '@kolkov/ngx-gallery';
import { ActivatedRoute, Params } from '@angular/router';
import { ImageUploadService } from '../file-base64/image-upload.service';
@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit {
  galleryOptions: NgxGalleryOptions[] = [];
  galleryImages: NgxGalleryImage[] = [];
  announcement_id: number;
  downloadedImages: string[] = [];

  convertStringToGalleryImages(): void {
    this.downloadedImages.forEach(async (imgString: string) => {
      const image: NgxGalleryImage = {
        small: imgString,
        medium: imgString,
        big: imgString
      }
      this.galleryImages.push(image);
      console.log("gallery Images " + image);
    });
  }

  getImages(): void {
    this.imageUploadService.getImages(this.announcement_id).subscribe(data => {
      this.downloadedImages = data;
      this.convertStringToGalleryImages();
    });
  }

  arrowNextIcon: 'fa fa-chevron-right';


  constructor(private route: ActivatedRoute, private imageUploadService: ImageUploadService) { }

  ngOnInit() {
    this.galleryOptions = [
      {
        // banner tak mozna
        'previewCloseOnEsc': true,
        'previewKeyboardNavigation': true,
        'imageBullets': true,
        // 'imageAutoPlay': true,
        imageArrows: true,
        previewArrows: true,
        thumbnailsArrows: true,
        width: '600px',
        height: '400px',
        thumbnailsColumns: 4,
        arrowPrevIcon: 'fa fa-chevron-left',
        arrowNextIcon: 'fa fa-chevron-right',
        imageAnimation: NgxGalleryAnimation.Slide,
        imageSwipe: true,
        imageArrowsAutoHide: false
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
        imageSwipe: true
        // thumbnailsArrows: true,
        // thumbnailsSwipe: true,
        // imageBullets: true,
        // arrowPrevIcon: fa-arrow-circle-o-left,


      },
      // max-width 400
      {
        breakpoint: 400,
        preview: false,
        imageSwipe: true
      }
    ];

    let thisUrl = this.route.snapshot.url[0].path;
    if(thisUrl != "addImages"){
      this.route.params.subscribe((params: Params) => {
        this.announcement_id = + params['id'];
      })
      this.getImages();
    } 
  }

}
