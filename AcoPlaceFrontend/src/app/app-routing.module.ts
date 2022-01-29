import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { AllInfoAnnouncementComponent } from './all-info-announcement/all-info-announcement.component';
import { AnnoucementActiveListComponent } from './annoucement-active-list/annoucement-active-list.component';
// import { AdminComponent } from './admin/admin.component';
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AnnouncementFavouriteListComponent } from './announcement-favourite-list/announcement-favourite-list.component';
import { AnnouncementInactiveListComponent } from './announcement-inactive-list/announcement-inactive-list.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { AuthGuard } from './auth.guard';
//Kod Wodnika
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { RegisterComponent } from './auth/register/register.component';
import { EditAnnouncementComponent } from './edit-announcement/edit-announcement.component';
import { FileBase64Component } from './file-base64/file-base64.component';
import { OtherUserProfileComponent } from './other-user-profile/other-user-profile.component';
//Koniec kodu Wodnika
import { UserProfileEditComponent } from './user-profile-edit/user-profile-edit.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
// import { UserProfileComponent } from './user-profile/user-profile.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatGridTileHarness } from '@angular/material/grid-list/testing';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';


const appRoutes: Routes = [

    { path: 'announcements-list', component: AnnouncementListComponent },
    { path: 'announcements-list2', component: AnnouncementListComponent },
    { path: 'announcement/:id', component: AnnouncementDetailsComponent },
    { path: 'add-announcement', component: AddAnnouncementComponent, canActivate: [AuthGuard] },
    { path: 'announcement-details-list', component: AnnouncementDetailsListComponent },
    { path: 'user-profile', component: UserProfileComponent },
    // { path: 'admin', component: AdminComponent },
    { path: '', component: AnnouncementListComponent },
    //Kod Wodnika
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register-success', component: RegisterSuccessComponent },
    { path: 'activeAnnouncement', component: AnnoucementActiveListComponent },
    { path: 'inactiveAnnouncement', component: AnnouncementInactiveListComponent },
    { path: 'favouriteAnnouncement', component: AnnouncementFavouriteListComponent },
    //Koniec kodu Wodnika
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register-success', component: RegisterSuccessComponent },
    { path: 'activeAnnouncement', component: AnnoucementActiveListComponent },
    { path: 'inactiveAnnouncement', component: AnnouncementInactiveListComponent },
    { path: 'announcementEdit/:id', component: EditAnnouncementComponent },
    { path: 'userEdit', component: UserProfileEditComponent },
    { path: 'addImages/:id', component: FileBase64Component },
    { path: 'allAnnouncement/:id', component: AllInfoAnnouncementComponent },
    { path: 'allUserInfo/:id', component: OtherUserProfileComponent },
    { path: 'privacy', component: PrivacyPolicyComponent }




];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
