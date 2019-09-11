import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFlightComfirmationComponent } from './user-flight-comfirmation.component';

describe('UserFlightComfirmationComponent', () => {
  let component: UserFlightComfirmationComponent;
  let fixture: ComponentFixture<UserFlightComfirmationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFlightComfirmationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFlightComfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
