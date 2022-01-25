import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../../../model/product.model";
import {ActionEvent, ProductQueryActions} from "../../../../state/product.state";
import {EventDrivenService} from "../../../../services/Event.driven.service";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  @Input() product ?: Product;
 // @Output() productsEventEmitter: EventEmitter<ActionEvent> = new EventEmitter();

  constructor(private eventDrivenService:EventDrivenService) {
  }

  ngOnInit(): void {
  }

  onSelect(product: Product) {
   // this.productsEventEmitter.emit({type: ProductQueryActions.SELECT_PRODUCT, payload: product})
    this.eventDrivenService.publishEvent({type: ProductQueryActions.SELECT_PRODUCT, payload: product})
  }

  onDelete(product: Product) {
    //this.productsEventEmitter.emit({type: ProductQueryActions.DELETE_PRODUCT, payload: product})
    this.eventDrivenService.publishEvent({type: ProductQueryActions.DELETE_PRODUCT, payload: product})
  }

  onEdit(product: Product) {
    //this.productsEventEmitter.emit({type: ProductQueryActions.EDIT_PRODUCT, payload: product})
    this.eventDrivenService.publishEvent({type: ProductQueryActions.EDIT_PRODUCT, payload: product})
  }
}
