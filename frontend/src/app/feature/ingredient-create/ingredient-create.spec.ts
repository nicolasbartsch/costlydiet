import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientCreate } from './ingredient-create';

describe('IngredientCreate', () => {
  let component: IngredientCreate;
  let fixture: ComponentFixture<IngredientCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngredientCreate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IngredientCreate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
