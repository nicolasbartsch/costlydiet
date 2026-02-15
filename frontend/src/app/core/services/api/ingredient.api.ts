import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IngredientCreateReqDto, IngredientCreateResDto, IngredientDetailDto, IngredientSearchResDto } from '../../../shared/model/ingredient';

@Injectable({
  providedIn: 'root',
})
export class IngredientApi {
  private readonly http = inject(HttpClient);

  searchIngredients(name: string) {
    return this.http.get<IngredientSearchResDto[]>(`http://localhost:8080/api/ingredients?name=${name}`)
  }

  getIngredient(id: number) {
    return this.http.get<IngredientDetailDto>(`http://localhost:8080/api/ingredients/${id}`)
  }

  addIngredient(ingredient: IngredientCreateReqDto) {
    return this.http.post<IngredientCreateResDto>(`http://localhost:8080/api/ingredients`, ingredient)
  }

}
