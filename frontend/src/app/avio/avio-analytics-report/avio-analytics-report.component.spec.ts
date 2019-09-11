import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvioAnalyticsReportComponent } from './avio-analytics-report.component';

describe('AvioAnalyticsReportComponent', () => {
  let component: AvioAnalyticsReportComponent;
  let fixture: ComponentFixture<AvioAnalyticsReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvioAnalyticsReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvioAnalyticsReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
