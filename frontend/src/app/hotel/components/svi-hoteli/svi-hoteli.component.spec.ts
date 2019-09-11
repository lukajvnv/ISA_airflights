import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SviHoteliComponent } from './svi-hoteli.component';

describe('SviHoteliComponent', () => {
  let component: SviHoteliComponent;
  let fixture: ComponentFixture<SviHoteliComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SviHoteliComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SviHoteliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
