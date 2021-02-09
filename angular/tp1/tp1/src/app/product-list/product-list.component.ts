import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  name: string;
  style: string;
  btnDisabled: boolean;
  products!: Array<any>;
  @Output()
  toggleEvent = new EventEmitter<boolean>();

  constructor() {
    this.name = 'Axel';
    this.style = 'hello';
    this.btnDisabled = true;
  }

  toggle(): void {
    this.btnDisabled = !this.btnDisabled;
    this.toggleEvent.emit(this.btnDisabled);
  }

  ngOnInit(): void {
    this.products = [{reference: 'P1', date: '2021'}];
    this.products.push({reference: 'p2', date: '2021'});
    this.products.push({reference: 'P3', date: '2020'});
  }

}
