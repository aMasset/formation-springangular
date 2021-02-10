import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ProductService} from '../../service/product-service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  productForm!: FormGroup;
  product = new Product();

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      const id = params.get('id');
      if (id !== null) {
        this.product = this.productService.findOne(+id);
      } else {
        this.product = new Product();
      }

      this.buildForm();
    });
  }

  buildForm(): void {
    this.productForm = this.formBuilder.group({
      reference: [this.product.reference, Validators.required],
      nom: [this.product.nom, Validators.required],
      prixUnitaire: [this.product.prixUnitaire, Validators.required],
      availibility: [this.product.availability, Validators.required]
    });
  }

  save(): void {
    if (this.product.id === null) {
      this.productService.create(this.product);
    } else {
      this.productService.update(this.product);
    }
  }
}
