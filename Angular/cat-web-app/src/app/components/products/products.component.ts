import {Component, OnInit} from '@angular/core';
import {catchError, map, Observable, of, startWith} from 'rxjs';
import {Product} from 'src/app/model/product.model';
import {ProductService} from '../../services/products.service';
import {ActionEvent, AppDataState, DataStateEnum, ProductQueryActions} from 'src/app/state/product.state';
import {Router} from "@angular/router";
import {EventDrivenService} from "../../services/Event.driven.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products$: Observable<AppDataState<Product[]>> | null = null;
  readonly DataStateEnum = DataStateEnum;

  constructor(private productService: ProductService,private router:Router,
              private eventDriverService:EventDrivenService) {
  }

  ngOnInit(): void {
    this.eventDriverService.sourceEventSubjectObservable.subscribe((actionEvent:ActionEvent)=>{
      this.onActionEvent(actionEvent);
    })
  }

  onGetAllProducts() {
    this.products$ = this.productService.getProducts().pipe(
      map(data => ({dataState: DataStateEnum.LOADED, data: data})),
      startWith({dataState: DataStateEnum.LOADING}),
      catchError(err => of({dataState: DataStateEnum.ERROR, errorMessage: err.message}))
    );
  }

  onGetSelectedProducts() {
    this.products$ = this.productService.getSelectedProducts().pipe(
      map(data => ({dataState: DataStateEnum.LOADED, data: data})),
      startWith({dataState: DataStateEnum.LOADING}),
      catchError(err => of({dataState: DataStateEnum.ERROR, errorMessage: err.message}))
    );
  }

  onGetAvailableProducts() {
    this.products$ = this.productService.getAvailableProducts().pipe(
      map(data => ({dataState: DataStateEnum.LOADED, data: data})),
      startWith({dataState: DataStateEnum.LOADING}),
      catchError(err => of({dataState: DataStateEnum.ERROR, errorMessage: err.message}))
    );
  }

  onSearch(dataForm: any) {
    this.products$ = this.productService.searchProducts(dataForm.keyword).pipe(
      map(data => ({dataState: DataStateEnum.LOADED, data: data})),
      startWith({dataState: DataStateEnum.LOADING}),
      catchError(err => of({dataState: DataStateEnum.ERROR, errorMessage: err.message}))
    );
  }

  onSelect(p: any) {
    this.productService.setSelected(p).subscribe(data => {
      p.selected = data.selected;
    })
  }

  onDelete(p: any) {
    let v = confirm("Etes vous sur de supprimer ce item ?")
    if (v == true)
      this.productService.deleteProduct(p).subscribe(data => {
        this.onGetAllProducts();
      })
  }

  onAddProducts() {
this.router.navigateByUrl("/newProduct")
  }
  onEdit(p:Product){
    this.router.navigateByUrl("/editProduct/"+p.id)
  }
  onActionEvent($event:ActionEvent){
    switch ($event.type){
      case ProductQueryActions.GET_ALL_PRODUCTS:this.onGetAllProducts();break;
      case ProductQueryActions.GET_AVAILABLE_PRODUCTS:this.onGetAvailableProducts();break;
      case ProductQueryActions.GET_SELECTED_PRODUCTS:this.onGetSelectedProducts();break;
      case ProductQueryActions.SEARCH_PRODUCT:this.onSearch($event.payload);break;
      case ProductQueryActions.NEW_PRODUCT:this.onAddProducts();break;
      case ProductQueryActions.EDIT_PRODUCT:this.onEdit($event.payload);break;
      case ProductQueryActions.SELECT_PRODUCT:this.onSelect($event.payload);break;
      case ProductQueryActions.DELETE_PRODUCT:this.onDelete($event.payload);break;

    }

  }
}
