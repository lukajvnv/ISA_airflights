import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFriendRequestComponent } from './user-friend-request.component';

describe('UserFriendRequestComponent', () => {
  let component: UserFriendRequestComponent;
  let fixture: ComponentFixture<UserFriendRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFriendRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFriendRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
