import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirlineFlightsComponent } from './view-airline-flights.component';

describe('ViewAirlineFlightsComponent', () => {
  let component: ViewAirlineFlightsComponent;
  let fixture: ComponentFixture<ViewAirlineFlightsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAirlineFlightsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirlineFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
