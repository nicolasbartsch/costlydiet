import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LucideAngularModule } from 'lucide-angular';
import { IngredientApi } from '../../core/services/api/ingredient.api';
import { IngredientCreateReqDto, IngredientDetailDto } from '../../shared/model/ingredient';

@Component({
  selector: 'app-ingredient-details',
  imports: [CommonModule, FormsModule, LucideAngularModule],
  templateUrl: './ingredient-details.html',
  styleUrl: './ingredient-details.css',
})
export class IngredientDetails {

  private ingredientApiService = inject(IngredientApi)
  private router = inject(Router);
  private route = inject(ActivatedRoute);


  protected ingredient = signal<IngredientDetailDto>({
    id: 0,
    name: '',
    price: 0,
    calories: 0,
    notes: ''
  });

  constructor() {
    const id = this.route.snapshot.params['id'];

    this.ingredientApiService.getIngredient(id).subscribe({
      next: (res) => {
        this.ingredient.set({
          id: res.id,
          name: res.name,
          price: res.price,
          calories: res.calories,
          notes: res.notes
        });
      },
      error: (err) => console.error("Error fetching ingredient", err)
    });
  }

  updateField<K extends keyof IngredientCreateReqDto>(field: K, value: any) {
    this.ingredient.update(prev => ({ ...prev, [field]: value }));
  }

  goBack() {
    this.router.navigate(['/ingredients'])
  }

  updateIngredient() {
    // TODO
  }

}
