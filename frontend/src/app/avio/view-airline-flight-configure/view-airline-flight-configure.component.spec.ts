import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirlineFlightConfigureComponent } from './view-airline-flight-configure.component';

describe('ViewAirlineFlightConfigureComponent', () => {
  let component: ViewAirlineFlightConfigureComponent;
  let fixture: ComponentFixture<ViewAirlineFlightConfigureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAirlineFlightConfigureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirlineFlightConfigureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
