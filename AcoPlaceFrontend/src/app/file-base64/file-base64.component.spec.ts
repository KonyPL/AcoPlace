import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FileBase64Component } from './file-base64.component';

describe('FileBase64Component', () => {
  let component: FileBase64Component;
  let fixture: ComponentFixture<FileBase64Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FileBase64Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FileBase64Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
