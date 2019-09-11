import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentabranchComponent } from './rentabranch.component';

describe('RentabranchComponent', () => {
  let component: RentabranchComponent;
  let fixture: ComponentFixture<RentabranchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentabranchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentabranchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
