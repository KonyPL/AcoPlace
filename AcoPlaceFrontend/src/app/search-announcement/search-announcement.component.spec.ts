import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchAnnouncementComponent } from './search-announcement.component';

describe('SearchAnnouncementComponent', () => {
  let component: SearchAnnouncementComponent;
  let fixture: ComponentFixture<SearchAnnouncementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchAnnouncementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchAnnouncementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
