import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajUsluguComponent } from './dodaj-uslugu.component';

describe('DodajUsluguComponent', () => {
  let component: DodajUsluguComponent;
  let fixture: ComponentFixture<DodajUsluguComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajUsluguComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajUsluguComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
