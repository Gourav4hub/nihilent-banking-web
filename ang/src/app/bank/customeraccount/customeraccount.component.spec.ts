import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomeraccountComponent } from './customeraccount.component';

describe('CustomeraccountComponent', () => {
  let component: CustomeraccountComponent;
  let fixture: ComponentFixture<CustomeraccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomeraccountComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomeraccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
