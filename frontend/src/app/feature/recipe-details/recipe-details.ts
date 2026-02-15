import { Component, inject, signal } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { RecipeApi } from '../../core/services/api/recipe.api';
import { RecipeDetailDto } from '../../shared/model/recipe';

@Component({
  selector: 'app-recipe-details',
  imports: [DecimalPipe],
  templateUrl: './recipe-details.html',
  styleUrl: './recipe-details.css',
})
export class RecipeDetails {

  private recipeApiService = inject(RecipeApi);
  private route = inject(ActivatedRoute);
  private router = inject(Router);

  recipe = signal<RecipeDetailDto | null>(null);

  constructor() {
    const idParam = this.route.snapshot.paramMap.get('id');

    if (idParam) {
      const id = +idParam; // convert to number
      this.recipeApiService.getRecipe(id).subscribe({
        next: (recipe) => this.recipe.set(recipe),
        error: (err) => console.error(err),
      });
    } else {
      console.error('No recipe ID found in URL');
    }
  }

  getPriceTotal(): number {
    return (this.recipe()?.priceTotal ?? 0) / 100;
  }

  goBack() {
    this.router.navigate([`recipes`])
  }

}
