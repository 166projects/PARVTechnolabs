import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetInterviewByTypeComponent } from './get-interview-by-type.component';

describe('GetInterviewByTypeComponent', () => {
  let component: GetInterviewByTypeComponent;
  let fixture: ComponentFixture<GetInterviewByTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetInterviewByTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetInterviewByTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
