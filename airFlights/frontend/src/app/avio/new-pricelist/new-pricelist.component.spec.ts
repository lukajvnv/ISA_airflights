import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPricelistComponent } from './new-pricelist.component';

describe('NewPricelistComponent', () => {
  let component: NewPricelistComponent;
  let fixture: ComponentFixture<NewPricelistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPricelistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPricelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
