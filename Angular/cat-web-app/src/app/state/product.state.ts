export enum ProductQueryActions {
  GET_ALL_PRODUCTS="GET_ALL_PRODUCTS",
  GET_SELECTED_PRODUCTS="GET_SELECTED_PRODUCTS",
  GET_AVAILABLE_PRODUCTS="GET_AVAILABLE_PRODUCTS",
  EDIT_PRODUCT="EDIT_PRODUCT",
  SEARCH_PRODUCT="SEARCH_PRODUCT",
  NEW_PRODUCT="NEW_PRODUCT",
  SELECT_PRODUCT="SELECT_PRODUCT",
  DELETE_PRODUCT="DELETE_PRODUCT",
  PRODUCT_ADDED="PRODUCT_ADDED",
  PRODUCT_UPDATED="PRODUCT_UPDATED",


}
export interface ActionEvent{
  type: ProductQueryActions,
  payload ?: any
}
export enum ProductCommandActions {
  ADD_PRODUCT="ADD_PRODUCT",
  DELETE_PRODUCT="DELETE_PRODUCT",
  UPDATE_PRODUCT="UPDATE_PRODUCT",
  SELECT_PRODUCT="SELECT_PRODUCT",
  EDIT_PRODUCT="EDIT_PRODUCT",
}

export enum DataStateEnum {
  LOADING,
  LOADED,
  ERROR,
}

export interface AppDataState<T> {
  dataState: DataStateEnum;
  data?: T;
  errorMessage?: string;
}