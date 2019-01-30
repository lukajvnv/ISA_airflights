import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFriendToFlightComponent } from './add-friend-to-flight.component';

describe('AddFriendToFlightComponent', () => {
  let component: AddFriendToFlightComponent;
  let fixture: ComponentFixture<AddFriendToFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFriendToFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFriendToFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
