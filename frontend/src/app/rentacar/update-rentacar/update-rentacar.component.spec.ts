import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRentacarComponent } from './update-rentacar.component';

describe('UpdateRentacarComponent', () => {
  let component: UpdateRentacarComponent;
  let fixture: ComponentFixture<UpdateRentacarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateRentacarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRentacarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
