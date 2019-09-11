import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RezervacijaSobeComponent } from './rezervacija-sobe.component';

describe('RezervacijaSobeComponent', () => {
  let component: RezervacijaSobeComponent;
  let fixture: ComponentFixture<RezervacijaSobeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RezervacijaSobeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RezervacijaSobeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
