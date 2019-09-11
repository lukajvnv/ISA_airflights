import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SobeNaPopustuComponent } from './sobe-na-popustu.component';

describe('SobeNaPopustuComponent', () => {
  let component: SobeNaPopustuComponent;
  let fixture: ComponentFixture<SobeNaPopustuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SobeNaPopustuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SobeNaPopustuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
