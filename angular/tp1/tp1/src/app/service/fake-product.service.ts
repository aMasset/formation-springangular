import {Injectable} from '@angular/core';
import {ProductService} from './product-service';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class FakeProductService implements ProductService {

  private products: Array<Product> = [
    {id: 1, reference: 'P1', nom: 'Produit 1', description: 'Best Produit 1', availability: 5, prixUnitaire: 250},
    {id: 2, reference: 'p2', nom: 'Produit 2', description: 'Best Produit 2', availability: 12, prixUnitaire: 1000},
    {id: 3, reference: 'P3', nom: 'Produit 3', description: 'Best Produit 3', availability: 25, prixUnitaire: 500}
  ];

  constructor() {
  }

  create(product: Product): Product {
    const max = this.products.reduce((acc, prod) => acc = acc > prod.id ? acc : prod.id, 0);
    product.id = max + 1;
    this.products.push(product);
    return product;
  }

  delete(id: number): void {
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        this.products.splice(i, 1);
      }
    }
  }

  findAll(): Array<Product> {
    return this.products;
  }

  findOne(id: number): Product {
    for (const product of this.products) {
      if (product.id === id) {
        return product;
      }
    }
    throw new Error('pas d\'entrée');
  }

  update(product: Product): Product {
    for (const p of this.products) {
      for (let i = 0; i < this.products.length; i++) {
        if (this.products[i].id === product.id) {
          this.products.splice(i, 1, product);
          // this.products.push(product);
          return product;
        }
      }
    }
    throw new Error('pas d\'entrée');
  }
}
