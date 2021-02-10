import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProductService} from '../service/product-service';
import {Product} from '../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  name: string;
  style: string;
  btnDisabled: boolean;
  products: Array<Product> = [];
  @Output()
  toggleEvent = new EventEmitter<boolean>();

  constructor(private productService: ProductService) {
    this.name = 'Axel';
    this.style = 'hello';
    this.btnDisabled = true;
    this.products = productService.findAll();
  }

  toggle(): void {
    this.btnDisabled = !this.btnDisabled;
    this.toggleEvent.emit(this.btnDisabled);
  }

  ngOnInit(): void {
  }

}
