import { Component, inject, signal, computed, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RecipeCreateReqDto, RecipeIngredientCreateReqDto, RecipeUpdateReqDto } from '../../shared/model/recipe';
import { NgForOf } from '@angular/common';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { RecipeApi } from '../../core/services/api/recipe.api';
import { LucideAngularModule } from 'lucide-angular';
import { ActivatedRoute, Router } from '@angular/router';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-recipe-edit',
  imports: [FormsModule, NgForOf, LucideAngularModule, DecimalPipe],
  templateUrl: './recipe-edit.html',
  styleUrl: './recipe-edit.css',
})
export class RecipeEdit implements OnInit {
  private recipeApi = inject(RecipeApi);
  private ingredientApi = inject(IngredientApi);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  private idParam = this.route.snapshot.paramMap.get('id');
  ingredients = signal<{ id: number; name: string, price: number, calories: number }[]>([]);
  selectedIngredients = signal<RecipeIngredientCreateReqDto[]>([]);
  loader = signal(true);

  recipeId = 0;
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

  ngOnInit() {
    // 1. Fetch the full list of selectable ingredients
    this.ingredientApi.searchIngredients('').subscribe({
      next: (res) => {
        this.ingredients.set(res);

        // 2. Fetch the recipe details only after ingredients are available
        const id = this.route.snapshot.paramMap.get('id');
        if (id) {
          this.recipeId = Number(id);
          this.recipeApi.getRecipe(this.recipeId).subscribe({
            next: (recipe) => {
              this.recipeName = recipe.name;
              this.instructions = recipe.instructions;

              // 3. Mapping is crucial: ensure 'id' is a number
              // The template [ngModel]="ing.id" needs a strict match in the <option [value]="opt.id">
              const mapped = recipe.recipeIngredients.map(ing => ({
                id: Number(ing.id),
                amount: ing.amount
              }));

              this.selectedIngredients.set(mapped);
              this.loader.set(false);

            }
          });
        }
      }
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
    const recipe: RecipeUpdateReqDto = {
      name: this.recipeName,
      instructions: this.instructions,
      recipeIngredients: this.selectedIngredients(),
    };

    this.recipeApi.updateRecipe(this.recipeId, recipe).subscribe({
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
