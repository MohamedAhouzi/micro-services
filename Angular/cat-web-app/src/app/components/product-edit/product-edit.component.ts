import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../../services/products.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductQueryActions} from "../../state/product.state";
import {EventDrivenService} from "../../services/Event.driven.service";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productId:number;
  productFormGroup?:FormGroup;
  public submitted:boolean=false;
  constructor(private activatedRoute:ActivatedRoute,
              private productService:ProductService,
              private fb:FormBuilder,
              private eventDrivenService:EventDrivenService) {
    this.productId= activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.productService.getProductById(this.productId)
      .subscribe(product=>{
       this.productFormGroup=this.fb.group({
         id:[product.id,Validators.required],
         name:[product.name,Validators.required],
         price:[product.price,Validators.required],
         quantity:[product.quantity,Validators.required],
         selected:[product.selected,Validators.required],
         available:[product.available,Validators.required],

       })
      })
  }
  onUpdateProduct(){
    //this.submitted = true;
    this.productService.update(this.productFormGroup?.value)
      .subscribe(data => {
        this.eventDrivenService.publishEvent({type:ProductQueryActions.PRODUCT_UPDATED})
        alert("product updated !!")
      })
  }

}
