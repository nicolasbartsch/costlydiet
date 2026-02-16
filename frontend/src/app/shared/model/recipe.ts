export interface RecipeSearchResDto {
  id: number;
  name: string;
}

export interface RecipeDetailDto {
  id: number;
  name: string;
  instructions: string;
  recipeIngredients: RecipeIngredientDetailDto[];
  priceTotal: number;
  caloriesTotal: number;
  amountTotal: number;
}

export interface RecipeIngredientDetailDto {
  name: string;
  amount: number;
  price: number;
  calories: number;
}

export interface RecipeCreateReqDto {
  name: string;
  instructions: string;
  recipeIngredients: RecipeIngredientCreateReqDto[];
}

export interface RecipeIngredientCreateReqDto {
  id: number;
  amount: number;
}

export interface RecipeUpdateReqDto {
  name: string;
  instructions: string;
  recipeIngredients: RecipeIngredientUpdateReqDto[];
}

export interface RecipeIngredientUpdateReqDto {
  id: number;
  amount: number;
}
