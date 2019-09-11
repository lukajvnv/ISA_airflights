import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelProfilnaComponent } from './hotel-profilna.component';

describe('HotelProfilnaComponent', () => {
  let component: HotelProfilnaComponent;
  let fixture: ComponentFixture<HotelProfilnaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelProfilnaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelProfilnaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
