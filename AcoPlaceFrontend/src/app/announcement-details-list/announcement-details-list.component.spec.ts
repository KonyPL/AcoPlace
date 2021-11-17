import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementDetailsListComponent } from './announcement-details-list.component';

describe('AnnouncementDetailsListComponent', () => {
  let component: AnnouncementDetailsListComponent;
  let fixture: ComponentFixture<AnnouncementDetailsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncementDetailsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncementDetailsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
