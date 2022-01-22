import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnoucementActiveListComponent } from './annoucement-active-list.component';

describe('AnnoucementActiveListComponent', () => {
  let component: AnnoucementActiveListComponent;
  let fixture: ComponentFixture<AnnoucementActiveListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnoucementActiveListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnoucementActiveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
