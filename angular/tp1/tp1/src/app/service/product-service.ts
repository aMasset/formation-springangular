import {Product} from '../model/product';

export abstract class ProductService {
  abstract findAll(): Array<Product>;

  abstract findOne(id: number): Product;

  abstract create(product: Product): Product;

  abstract update(product: Product): Product;

  abstract delete(id: number): void;
}
