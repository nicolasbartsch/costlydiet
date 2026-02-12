import { TestBed } from '@angular/core/testing';

import { IngredientApi } from './ingredient.api';

describe('IngredientApi', () => {
  let service: IngredientApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngredientApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
