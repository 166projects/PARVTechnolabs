import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetEligibleCandidateComponent } from './get-eligible-candidate-component.component';

describe('GetEligibleCandidateComponentComponent', () => {
  let component: GetEligibleCandidateComponent;
  let fixture: ComponentFixture<GetEligibleCandidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetEligibleCandidateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetEligibleCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
