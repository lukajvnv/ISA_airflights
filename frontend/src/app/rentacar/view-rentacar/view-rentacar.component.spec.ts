import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRentacarComponent } from './view-rentacar.component';

describe('ViewRentacarComponent', () => {
  let component: ViewRentacarComponent;
  let fixture: ComponentFixture<ViewRentacarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewRentacarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRentacarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
