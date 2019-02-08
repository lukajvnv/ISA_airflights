import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllAirlinesComponent } from './view-all-airlines.component';

describe('ViewAllAirlinesComponent', () => {
  let component: ViewAllAirlinesComponent;
  let fixture: ComponentFixture<ViewAllAirlinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllAirlinesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllAirlinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
