import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnnouncementDetailsComponent } from './announcement-details/announcement-details.component';
import { AnnouncementListComponent } from './announcement-list/announcement-list.component';
import { PlacesListComponent } from './places-list/places-list.component';



const appRoutes: Routes = [

    { path: 'announcements-list', component: AnnouncementListComponent },
    { path: 'places-list', component: PlacesListComponent },
    { path: 'announcement/:id', component: AnnouncementDetailsComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
