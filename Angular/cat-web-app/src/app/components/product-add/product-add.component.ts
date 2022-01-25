import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../services/products.service";
import {EventDrivenService} from "../../services/Event.driven.service";
import {ProductQueryActions} from "../../state/product.state";

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  public productFormGroup?: FormGroup;
  public submitted: boolean = false;

  constructor(private fb: FormBuilder, private productServie: ProductService,
              private eventDrivenService:EventDrivenService) {
  }

  ngOnInit(): void {
    this.productFormGroup = this.fb.group({
        name: ["", Validators.required],
        price: [0, Validators.required],
        quantity: [0, Validators.required],
        selected: [true, Validators.required],
        available: [true, Validators.required],
      }
    )
  }

  onSaveProduct() {
    this.submitted = true;
    if (this.productFormGroup?.invalid) return;
    this.productServie.save(this.productFormGroup?.value)
      .subscribe(data => {
        this.eventDrivenService.publishEvent({type:ProductQueryActions.PRODUCT_ADDED})
        alert("product saved !!")
      })
  }

}
