import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneWayFlightResultComponent } from './one-way-flight-result.component';

describe('OneWayFlightResultComponent', () => {
  let component: OneWayFlightResultComponent;
  let fixture: ComponentFixture<OneWayFlightResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneWayFlightResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneWayFlightResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
