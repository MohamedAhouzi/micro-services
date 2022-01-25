import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActionEvent, ProductQueryActions} from "../../../state/product.state";
import {EventDrivenService} from "../../../services/Event.driven.service";

@Component({
  selector: 'app-products-nav-bar',
  templateUrl: './products-nav-bar.component.html',
  styleUrls: ['./products-nav-bar.component.css']
})
export class ProductsNavBarComponent implements OnInit {
  //@Output() productEventEmitter:EventEmitter<ActionEvent>=new EventEmitter();
  constructor(private eventDrivenService:EventDrivenService) { }

  ngOnInit(): void {
  }

  onGetAvailableProducts() {
    this.eventDrivenService.publishEvent({type:ProductQueryActions.GET_AVAILABLE_PRODUCTS})
   // this.productEventEmitter.emit({type:ProductQueryActions.GET_AVAILABLE_PRODUCTS});
  }

  onGetSelectedProducts() {
    //this.productEventEmitter.emit({type:ProductQueryActions.GET_SELECTED_PRODUCTS});
    this.eventDrivenService.publishEvent({type:ProductQueryActions.GET_SELECTED_PRODUCTS})
  }

  onAddProducts() {
    //this.productEventEmitter.emit({type:ProductQueryActions.NEW_PRODUCT});
    this.eventDrivenService.publishEvent({type:ProductQueryActions.NEW_PRODUCT})
  }

  onSearch(dataForm: any) {
   // this.productEventEmitter.emit({type:ProductQueryActions.SEARCH_PRODUCT,payload:dataForm});
    this.eventDrivenService.publishEvent({type:ProductQueryActions.SEARCH_PRODUCT,payload:dataForm})
  }

  onGetAllProducts() {
  //this.productEventEmitter.emit({type:ProductQueryActions.GET_ALL_PRODUCTS});
    this.eventDrivenService.publishEvent({type:ProductQueryActions.GET_ALL_PRODUCTS})
  }
}
