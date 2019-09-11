import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvioAnalyticsMarksComponent } from './avio-analytics-marks.component';

describe('AvioAnalyticsMarksComponent', () => {
  let component: AvioAnalyticsMarksComponent;
  let fixture: ComponentFixture<AvioAnalyticsMarksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvioAnalyticsMarksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvioAnalyticsMarksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
