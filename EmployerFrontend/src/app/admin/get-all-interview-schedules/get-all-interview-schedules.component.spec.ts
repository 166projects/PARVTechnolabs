import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllInterviewSchedulesComponent } from './get-all-interview-schedules.component';

describe('GetAllInterviewSchedulesComponent', () => {
  let component: GetAllInterviewSchedulesComponent;
  let fixture: ComponentFixture<GetAllInterviewSchedulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllInterviewSchedulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllInterviewSchedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
