export interface IngredientSearchResDto {
  id: number;
  name: string;
  price: number;
  calories: number;
  notes: string;
}

export interface IngredientCreateReqDto {
  name: string;
  price: number;
  calories: number;
  notes: string;
}

export interface IngredientCreateResDto {
  id: number;
  name: string;
  price: number;
  calories: number;
  notes: string;
}
