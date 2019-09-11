import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRentabranchComponent } from './new-rentabranch.component';

describe('NewRentabranchComponent', () => {
  let component: NewRentabranchComponent;
  let fixture: ComponentFixture<NewRentabranchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewRentabranchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRentabranchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
