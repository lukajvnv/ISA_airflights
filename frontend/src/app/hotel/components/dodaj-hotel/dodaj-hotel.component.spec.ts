import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajHotelComponent } from './dodaj-hotel.component';

describe('DodajHotelComponent', () => {
  let component: DodajHotelComponent;
  let fixture: ComponentFixture<DodajHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
