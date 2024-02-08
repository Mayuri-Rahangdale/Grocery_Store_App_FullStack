import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroceryUpdateComponent } from './grocery-update.component';

describe('GroceryUpdateComponent', () => {
  let component: GroceryUpdateComponent;
  let fixture: ComponentFixture<GroceryUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GroceryUpdateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GroceryUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
