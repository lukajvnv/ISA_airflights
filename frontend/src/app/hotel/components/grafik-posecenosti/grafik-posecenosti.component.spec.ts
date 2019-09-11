import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrafikPosecenostiComponent } from './grafik-posecenosti.component';

describe('GrafikPosecenostiComponent', () => {
  let component: GrafikPosecenostiComponent;
  let fixture: ComponentFixture<GrafikPosecenostiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrafikPosecenostiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrafikPosecenostiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
