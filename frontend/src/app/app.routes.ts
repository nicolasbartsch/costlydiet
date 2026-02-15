import { Routes } from '@angular/router';
import { MainLayout } from './core/components/main-layout/main-layout';
import { IngredientList } from './feature/ingredient-list/ingredient-list';
import { IngredientCreate } from './feature/ingredient-create/ingredient-create';
import { IngredientDetails } from './feature/ingredient-details/ingredient-details';
import { RecipeList } from './feature/recipe-list/recipe-list';

export const routes: Routes = [
  {
    path: '',
    component: MainLayout,
    children: [
      {
        path: 'ingredients',
        component: IngredientList
      },
      {
        path: 'ingredients/create',
        component: IngredientCreate
      },
      {
        path: 'ingredients/:id',
        component: IngredientDetails
      },
      {
        path: 'recipes',
        component: RecipeList
      },
    ]
  }
];

