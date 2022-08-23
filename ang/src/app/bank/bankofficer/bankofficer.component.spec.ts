import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankofficerComponent } from './bankofficer.component';

describe('BankofficerComponent', () => {
  let component: BankofficerComponent;
  let fixture: ComponentFixture<BankofficerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BankofficerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BankofficerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
