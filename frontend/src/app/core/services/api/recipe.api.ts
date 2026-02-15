import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { RecipeSearchResDto, RecipeDetailDto, RecipeCreateReqDto } from '../../../shared/model/recipe';

@Injectable({
  providedIn: 'root',
})
export class RecipeApi {

  private readonly http = inject(HttpClient);

  searchRecipes(name: string) {
    return this.http.get<RecipeSearchResDto[]>(`http://localhost:8080/api/recipes?name=${name}`)
  }

  getRecipe(recipeId: number) {
    return this.http.get<RecipeDetailDto>(`http://localhost:8080/api/recipes/${recipeId}`)
  }

  createRecipe(recipe: RecipeCreateReqDto) {
    return this.http.post<RecipeDetailDto>('http://localhost:8080/api/recipes', recipe)
  }

}
