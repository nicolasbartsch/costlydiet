import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientDetails } from './ingredient-details';

describe('IngredientDetails', () => {
  let component: IngredientDetails;
  let fixture: ComponentFixture<IngredientDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngredientDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngredientDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
