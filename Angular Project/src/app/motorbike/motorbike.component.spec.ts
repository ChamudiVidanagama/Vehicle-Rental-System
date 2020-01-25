import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotorbikeComponent } from './motorbike.component';

describe('MotorbikeComponent', () => {
  let component: MotorbikeComponent;
  let fixture: ComponentFixture<MotorbikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotorbikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotorbikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
