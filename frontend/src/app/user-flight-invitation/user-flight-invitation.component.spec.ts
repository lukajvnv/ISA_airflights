import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFlightInvitationComponent } from './user-flight-invitation.component';

describe('UserFlightInvitationComponent', () => {
  let component: UserFlightInvitationComponent;
  let fixture: ComponentFixture<UserFlightInvitationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFlightInvitationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFlightInvitationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
