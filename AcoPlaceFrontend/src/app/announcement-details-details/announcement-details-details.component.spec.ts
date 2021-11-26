import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementDetailsDetailsComponent } from './announcement-details-details.component';

describe('AnnouncementDetailsDetailsComponent', () => {
  let component: AnnouncementDetailsDetailsComponent;
  let fixture: ComponentFixture<AnnouncementDetailsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncementDetailsDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncementDetailsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
