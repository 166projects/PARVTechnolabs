import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRatingsComponent } from './update-ratings.component';

describe('UpdateRatingsComponent', () => {
  let component: UpdateRatingsComponent;
  let fixture: ComponentFixture<UpdateRatingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateRatingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRatingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
