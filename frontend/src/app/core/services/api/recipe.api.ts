import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { RecipeSearchResDto } from '../../../shared/model/recipe';

@Injectable({
  providedIn: 'root',
})
export class RecipeApi {

  private readonly http = inject(HttpClient);

  searchRecipes(name: string) {
    return this.http.get<RecipeSearchResDto[]>(`http://localhost:8080/api/recipes?name=${name}`)
  }

}
