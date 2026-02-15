import { Component, inject, signal } from '@angular/core';
import { Router, RouterLink, } from '@angular/router';
import { RecipeSearchResDto } from '../../shared/model/recipe';
import { FormsModule } from '@angular/forms';
import { RecipeApi } from '../../core/services/api/recipe.api';

@Component({
  selector: 'app-recipe-list',
  imports: [FormsModule, RouterLink],
  templateUrl: './recipe-list.html',
  styleUrl: './recipe-list.css',
})
export class RecipeList {
  private recipeApiService = inject(RecipeApi);
  private router = inject(Router);

  protected recipes = signal<RecipeSearchResDto[] | null>(null);
  protected searchQuery = '';

  get filteredRecipes(): RecipeSearchResDto[] {
    return (this.recipes() || []).filter(r =>
      r.name.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
  }

  constructor() {
    this.recipeApiService.searchRecipes('')
      .subscribe({
        next: (recipes) => {
          this.recipes.set(recipes);
        },
        error: (err) => {
          console.error(err);
        }
      })
  }

  getDetails(recipeId: number) {
    this.router.navigate([`recipes/${recipeId}`])
  }

}
