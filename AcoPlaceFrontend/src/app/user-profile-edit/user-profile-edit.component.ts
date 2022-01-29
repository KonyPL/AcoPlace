import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProfileDto } from '../model/user-profile-dto';
import { UserService } from '../sidebar/user.service';
import { ImageCompressorService, CompressorConfig } from 'ngx-image-compressor';
import { NgxImageCompressService } from 'ngx-image-compress';
import { ImageStorage } from '../model/image-storage';

@Component({
  selector: 'app-user-profile-edit',
  templateUrl: './user-profile-edit.component.html',
  styleUrls: ['./user-profile-edit.component.css']
})
export class UserProfileEditComponent implements OnInit {

  userProfileDto: UserProfileDto;

  constructor(private userService: UserService, private router: Router, private imageCompressor: ImageCompressorService) { }

  ngOnInit(): void {
    this.getUserDetails();
  }


  public getUserDetails(){
    this.userService.getCurrentUserProfileDto().subscribe(
      data => {
        this.userProfileDto = data;
        console.log("DATA from endpoint about" + data.about);
        console.log("DATA from endpoint about" + data.countryCode);
        console.log("DATA from endpoint about" + data.email);
        console.log("DATA from endpoint about" + data.userName);
        console.log("DATA from endpoint about" + data.lastName);
        console.log("DATA from endpoint about" + data.firstName);


      }
    )  }


    goToUserProfile() {
      this.router.navigate(['user-profile']);
    }

    onEdit(){
      this.userService.updateUserByDto(this.userProfileDto).subscribe();
      this.goToUserProfile();
    }

    //User profile picture
    onSelectNewFile(files: FileList): void {
      const rawFiles: File[] = [].slice.call(files);
      rawFiles.forEach(async (file: File) => {
        const config: CompressorConfig = { orientation: 1, ratio: 100, quality: 70, enableLogs: true };
        this.convertFileToBase64(await this.imageCompressor.compressFile(file, config));
      })
  
    }
  
    convertFileToBase64(blob: Blob): void {
      let reader = new FileReader();
      reader.readAsDataURL(blob as Blob);
      reader.onloadend = () => {
        this.userProfileDto.b64image = (reader.result as string);
      }
    }

}
