import { Routes } from '@angular/router';
import { MainLayout } from './core/components/main-layout/main-layout';
import { IngredientList } from './feature/ingredient-list/ingredient-list';

export const routes: Routes = [
  {
    path: '',
    component: MainLayout,
    children: [
      { path: 'ingredients', component: IngredientList },
    ]
  }
];

