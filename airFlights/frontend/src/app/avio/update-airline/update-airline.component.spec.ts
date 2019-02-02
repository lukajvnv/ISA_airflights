import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAirlineComponent } from './update-airline.component';

describe('UpdateAirlineComponent', () => {
  let component: UpdateAirlineComponent;
  let fixture: ComponentFixture<UpdateAirlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateAirlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAirlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
