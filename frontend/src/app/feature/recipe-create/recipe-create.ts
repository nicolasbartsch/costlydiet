import { Component, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RecipeCreateReqDto, RecipeIngredientCreateReqDto } from '../../shared/model/recipe';
import { NgForOf } from '@angular/common';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { RecipeApi } from '../../core/services/api/recipe.api';
import { LucideAngularModule } from 'lucide-angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-create',
  imports: [FormsModule, NgForOf, LucideAngularModule],
  templateUrl: './recipe-create.html',
  styleUrl: './recipe-create.css',
})
export class RecipeCreate {
  private recipeApi = inject(RecipeApi);
  private ingredientApi = inject(IngredientApi);
  private router = inject(Router);

  ingredients = signal<{ id: number; name: string }[]>([]);
  recipeName = '';
  instructions = '';
  selectedIngredients = signal<RecipeIngredientCreateReqDto[]>([]);

  constructor() {
    this.ingredientApi.searchIngredients('').subscribe({
      next: (res) => this.ingredients.set(res),
      error: (err) => console.error(err),
    });
  }

  addIngredient() {
    this.selectedIngredients.update(list => [...list, { id: 0, amount: 0 }]);
  }

  removeIngredient(index: number) {
    this.selectedIngredients.update(list => list.filter((_, i) => i !== index));
  }

  updateIngredient(index: number, field: 'id' | 'amount', value: number) {
    this.selectedIngredients.update(list => {
      const updated = [...list];
      updated[index] = { ...updated[index], [field]: value };
      return updated;
    });
  }


  submit() {
    const recipe: RecipeCreateReqDto = {
      name: this.recipeName,
      instructions: this.instructions,
      recipeIngredients: this.selectedIngredients(),
    };

    this.recipeApi.createRecipe(recipe).subscribe({
      next: () => alert('Recipe created!'),
      error: (err) => console.error(err),
    });
  }

  goBack() {
    this.router.navigate(['/recipes'])
  }
}
