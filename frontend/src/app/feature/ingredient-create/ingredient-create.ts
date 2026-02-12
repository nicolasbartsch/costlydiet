import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LucideAngularModule } from 'lucide-angular';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { IngredientCreateReqDto } from '../../shared/model/ingredient';

@Component({
  selector: 'app-ingredient-create',
  imports: [CommonModule, FormsModule, LucideAngularModule],
  templateUrl: './ingredient-create.html',
  styleUrl: './ingredient-create.css',
})
export class IngredientCreate {

  private ingredientApiService = inject(IngredientApi)
  private router = inject(Router);

  protected ingredient = signal<IngredientCreateReqDto>({
    name: '',
    price: 0,
    calories: 0,
    notes: ''
  });

  updateField<K extends keyof IngredientCreateReqDto>(field: K, value: any) {
    this.ingredient.update(prev => ({ ...prev, [field]: value }));
  }

  goBack() {
    this.router.navigate(['/ingredients'])
  }

  saveIngredient() {
    this.ingredientApiService.addIngredient(this.ingredient()).subscribe({
      next: () => this.goBack(),
      error: (err) => console.error('Failed to save', err)
    });
  }

}
