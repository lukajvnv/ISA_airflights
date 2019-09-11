import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirlineTicketsComponent } from './view-airline-tickets.component';

describe('ViewAirlineTicketsComponent', () => {
  let component: ViewAirlineTicketsComponent;
  let fixture: ComponentFixture<ViewAirlineTicketsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAirlineTicketsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirlineTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
