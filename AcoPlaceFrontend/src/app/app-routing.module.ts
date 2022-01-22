import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAnnouncementComponent } from './add-announcement/add-announcement.component';
import { AnnoucementActiveListComponent } from './annoucement-active-list/annoucement-active-list.component';
// import { AdminComponent } from './admin/admin.component';
import { AnnouncementDetailsListComponent } from './announcement-details-list/announcement-details-list.component';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AnnouncementInactiveListComponent } from './announcement-inactive-list/announcement-inactive-list.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { AuthGuard } from './auth.guard';
//Kod Wodnika
import { LoginComponent } from './auth/login/login.component';
import { RegisterSuccessComponent } from './auth/register-success/register-success.component';
import { RegisterComponent } from './auth/register/register.component';
//Koniec kodu Wodnika
import { SearchAnnouncementComponent } from './search-announcement/search-announcement.component';
import { StartPageComponent } from './start-page/start-page.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
// import { UserProfileComponent } from './user-profile/user-profile.component';



const appRoutes: Routes = [

    { path: 'announcements-list', component: AnnouncementListComponent },
    { path: 'announcement/:id', component: AnnouncementDetailsComponent },
    { path: 'add-announcement', component: AddAnnouncementComponent, canActivate: [AuthGuard]},
    { path: 'announcement-details-list', component: AnnouncementDetailsListComponent },
    { path: 'search-announcement', component: SearchAnnouncementComponent },
    { path: 'user-profile', component: UserProfileComponent },
    // { path: 'admin', component: AdminComponent },
    { path: 'start', component: StartPageComponent },
    { path: '', component: StartPageComponent },
    //Kod Wodnika
    {path: 'register', component: RegisterComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register-success', component: RegisterSuccessComponent},
    {path: 'activeAnnouncement', component: AnnoucementActiveListComponent},
    {path: 'inactiveAnnouncement', component: AnnouncementInactiveListComponent}
    //Koniec kodu Wodnika


];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
