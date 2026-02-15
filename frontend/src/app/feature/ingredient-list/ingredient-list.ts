import { inject, Component, signal } from '@angular/core';
import { Router } from '@angular/router';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { IngredientSearchResDto } from '../../shared/model/ingredient';
import { FormsModule } from '@angular/forms';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-ingredient-list',
  imports: [FormsModule, LucideAngularModule],
  templateUrl: './ingredient-list.html',
  styleUrl: './ingredient-list.css',
})
export class IngredientList {

  private ingredientApiService = inject(IngredientApi)
  private router = inject(Router);

  protected ingredients = signal<IngredientSearchResDto[] | null>(null);
  protected searchQuery = '';

  get filteredIngredients(): IngredientSearchResDto[] {
    return (this.ingredients() || []).filter(i =>
      i.name.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
  }

  constructor() {
    this.ingredientApiService.searchIngredients('')
      .subscribe({
        next: (ingredients) => {
          this.ingredients.set(ingredients);
        },
        error: (err) => {
          console.error(err);
        }
      })
  }

  create() {
    this.router.navigate(['/ingredients/create'])
  }

  onCardClick(id: number) {
    this.router.navigate([`/ingredients/${id}`])
  }
}
