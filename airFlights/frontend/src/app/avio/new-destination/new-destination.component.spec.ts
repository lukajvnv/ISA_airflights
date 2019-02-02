import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDestinationComponent } from './new-destination.component';

describe('NewDestinationComponent', () => {
  let component: NewDestinationComponent;
  let fixture: ComponentFixture<NewDestinationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewDestinationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewDestinationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
