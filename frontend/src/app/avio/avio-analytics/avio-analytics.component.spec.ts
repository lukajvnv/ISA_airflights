import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvioAnalyticsComponent } from './avio-analytics.component';

describe('AvioAnalyticsComponent', () => {
  let component: AvioAnalyticsComponent;
  let fixture: ComponentFixture<AvioAnalyticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvioAnalyticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvioAnalyticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
