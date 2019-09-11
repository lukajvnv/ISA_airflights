import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHotelaComponent } from './admin-hotela.component';

describe('AdminHotelaComponent', () => {
  let component: AdminHotelaComponent;
  let fixture: ComponentFixture<AdminHotelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHotelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHotelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
