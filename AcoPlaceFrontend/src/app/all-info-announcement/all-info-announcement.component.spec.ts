import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllInfoAnnouncementComponent } from './all-info-announcement.component';

describe('AllInfoAnnouncementComponent', () => {
  let component: AllInfoAnnouncementComponent;
  let fixture: ComponentFixture<AllInfoAnnouncementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllInfoAnnouncementComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllInfoAnnouncementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
