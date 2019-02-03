import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvioAnalyticsIncomeComponent } from './avio-analytics-income.component';

describe('AvioAnalyticsIncomeComponent', () => {
  let component: AvioAnalyticsIncomeComponent;
  let fixture: ComponentFixture<AvioAnalyticsIncomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvioAnalyticsIncomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvioAnalyticsIncomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
