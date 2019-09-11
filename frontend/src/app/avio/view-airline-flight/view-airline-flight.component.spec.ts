import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirlineFlightComponent } from './view-airline-flight.component';

describe('ViewAirlineFlightComponent', () => {
  let component: ViewAirlineFlightComponent;
  let fixture: ComponentFixture<ViewAirlineFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAirlineFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirlineFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
