import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {ProductListComponent} from './product-list/product-list.component';
import {FormsModule} from '@angular/forms';
import {FakeProductService} from './service/fake-product.service';
import {ProductService} from './service/product-service';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [{provide: ProductService, useClass: FakeProductService}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
