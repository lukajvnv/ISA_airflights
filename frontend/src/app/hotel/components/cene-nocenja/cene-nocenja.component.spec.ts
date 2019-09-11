import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CeneNocenjaComponent } from './cene-nocenja.component';

describe('CeneNocenjaComponent', () => {
  let component: CeneNocenjaComponent;
  let fixture: ComponentFixture<CeneNocenjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CeneNocenjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CeneNocenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
