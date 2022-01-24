import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BannerGalleryComponent } from './banner-gallery.component';

describe('BannerGalleryComponent', () => {
  let component: BannerGalleryComponent;
  let fixture: ComponentFixture<BannerGalleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BannerGalleryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BannerGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
