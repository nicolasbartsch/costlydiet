import { Component, inject, signal, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RecipeCreateReqDto, RecipeIngredientCreateReqDto } from '../../shared/model/recipe';
import { NgForOf } from '@angular/common';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { RecipeApi } from '../../core/services/api/recipe.api';
import { LucideAngularModule } from 'lucide-angular';
import { Router } from '@angular/router';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-recipe-create',
  imports: [FormsModule, NgForOf, LucideAngularModule, DecimalPipe],
  templateUrl: './recipe-create.html',
  styleUrl: './recipe-create.css',
})
export class RecipeCreate {
  private recipeApi = inject(RecipeApi);
  private ingredientApi = inject(IngredientApi);
  private router = inject(Router);

  ingredients = signal<{ id: number; name: string, price: number, calories: number }[]>([]);
  selectedIngredients = signal<RecipeIngredientCreateReqDto[]>([]);

  recipeName = '';
  instructions = '';

  totalPrice = computed(() => {
    return this.selectedIngredients().reduce((acc, selected) => {
      const data = this.ingredients().find(i => i.id === Number(selected.id));
      // Price in cents/kg -> Euro per gram: (price / 100 / 1000)
      return acc + (data ? ((data.price / 100000) * selected.amount) : 0);
    }, 0);
  });

  totalCalories = computed(() => {
    return this.selectedIngredients().reduce((acc, selected) => {
      const data = this.ingredients().find(i => i.id === Number(selected.id));
      // Calories per 100g -> kcal per gram: (calories / 100)
      return acc + (data ? ((data.calories / 100) * selected.amount) : 0);
    }, 0);
  });


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

  updateIngredient(index: number, field: 'id' | 'amount', value: any) {
    this.selectedIngredients.update(list => {
      const updated = [...list];
      // Force the value to be a number
      updated[index] = { ...updated[index], [field]: Number(value) };
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
      next: () => this.goBack(),
      error: (err) => console.error(err),
    });
  }

  goBack() {
    this.router.navigate(['/recipes'])
  }

  trackByIndex(index: number, item: any) {
    return index; // Tells Angular to track items by their position in the list
  }

}
