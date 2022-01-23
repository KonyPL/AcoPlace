import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementFavouriteListComponent } from './announcement-favourite-list.component';

describe('AnnouncementFavouriteListComponent', () => {
  let component: AnnouncementFavouriteListComponent;
  let fixture: ComponentFixture<AnnouncementFavouriteListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncementFavouriteListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncementFavouriteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
