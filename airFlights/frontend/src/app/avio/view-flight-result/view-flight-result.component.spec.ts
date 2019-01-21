import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewFlightResultComponent } from './view-flight-result.component';

describe('ViewFlightResultComponent', () => {
  let component: ViewFlightResultComponent;
  let fixture: ComponentFixture<ViewFlightResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewFlightResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewFlightResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
