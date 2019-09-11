import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchRentacarComponent } from './search-rentacar.component';

describe('SearchRentacarComponent', () => {
  let component: SearchRentacarComponent;
  let fixture: ComponentFixture<SearchRentacarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchRentacarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchRentacarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
