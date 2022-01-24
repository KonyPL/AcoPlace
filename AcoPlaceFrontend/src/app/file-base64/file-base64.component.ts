import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Image } from '../model';
import { ImageCompressorService, CompressorConfig } from 'ngx-image-compressor';
import { NgxImageCompressService } from 'ngx-image-compress';
import { ImageStorage } from '../model/image-storage';
import { ImageUploadService } from './image-upload.service';
@Component({
  selector: 'app-file-base64',
  templateUrl: './file-base64.component.html',
  styleUrls: ['./file-base64.component.css']
})
export class FileBase64Component implements OnInit {

  base64: string[] = [];
  compressedFiles: File[] = [];
  imageUrl?: string;

  imgResult: string = "";

  //czy tak jest ok?
  announcementId: number;

  //debug
  downloaded: string[] = [];

  constructor(private sant: DomSanitizer, private imageCompressor: ImageCompressorService,
    private imageUploadService: ImageUploadService) { }

  ngOnInit(): void {
  }

  onSelectNewFile(files: FileList): void {
    const rawFiles: File[] = [].slice.call(files);
    rawFiles.forEach(async (file: File) => {
      const config: CompressorConfig = { orientation: 1, ratio: 50, quality: 50, enableLogs: true };
      this.compressedFiles.push(await this.imageCompressor.compressFile(file, config));
    });
  }

  convertFileToBase64(): void {
    this.compressedFiles.forEach(async (blob: Blob) => {
      let reader = new FileReader();
      reader.readAsDataURL(blob as Blob);
      reader.onloadend = () => {
        this.base64.push(reader.result as string);
      }
    });
  }

  sendImages(): void {
    let images: ImageStorage[] = [];
    this.base64.forEach(async (encoded: string) => {
      let imageStorage: ImageStorage = new ImageStorage();
      imageStorage.b64image = encoded;
      console.log(imageStorage)
      images.push(imageStorage)
    });

    this.imageUploadService.addImages(this.announcementId, images).subscribe()
  }

  getImages(announcementId: number): void {
    this.imageUploadService.getImages(announcementId).subscribe(
      data => {
        this.downloaded = data;
        console.log("DATA from endpoint" + data);
      }
    )
  }
}
