import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncementInactiveListComponent } from './announcement-inactive-list.component';

describe('AnnouncementInactiveListComponent', () => {
  let component: AnnouncementInactiveListComponent;
  let fixture: ComponentFixture<AnnouncementInactiveListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncementInactiveListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnouncementInactiveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
