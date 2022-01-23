import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-file-base64',
  templateUrl: './file-base64.component.html',
  styleUrls: ['./file-base64.component.css']
})
export class FileBase64Component implements OnInit {

  base64: string = "Base64...";
  fileSelected?: Blob;
  imageUrl?: string;

  constructor(private sant: DomSanitizer) { }

  ngOnInit(): void {
  }

  fileInput = document.getElementById('pictureInput');

  public getFileById(event: any) {
    console.log("pobieram plik");

  }

  // This is for storing the base64 strings
  // myFiles = {};
  // if you expect files by default, make this disabled
  // we will wait until the last file being processed
  isFilesReady = true;

  //   fileInput.addEventListener('change', async (event: any) => {
  //   const files = event.srcElement.files;

  //   console.log(files)
  // });

  public handleUpload(event: any) {
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      console.log(reader.result);
    };
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }


  onSelectNewFile(files: FileList): void {
    this.fileSelected = files[0];
    this.imageUrl = this.sant.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;
    this.base64 = "Base64...";
  }

  convertFileToBase64(): void {
    let reader = new FileReader();
    reader.readAsDataURL(this.fileSelected as Blob);
    reader.onloadend = () => {
      this.base64 = reader.result as string;
    }
  }



}


