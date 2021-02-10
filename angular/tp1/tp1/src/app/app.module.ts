import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {ProductListComponent} from './product/product-list/product-list.component';
import {FormsModule} from '@angular/forms';
import {FakeProductService} from './service/fake-product.service';
import {ProductService} from './service/product-service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NavigationBarComponent} from './navigation-bar/navigation-bar.component';
import {RouterModule, Routes} from '@angular/router';
import {FournisseurListComponent} from './fournisseur/fournisseur-list/fournisseur-list.component';
import {ProductPageComponent} from './product/product-page/product-page.component';
import {FournisseurPageComponent} from './fournisseur/fournisseur-page/fournisseur-page.component';
import {ProductDetailComponent} from './product/product-detail/product-detail.component';

const productsRoutes: Routes = [
  {path: 'list', component: ProductListComponent},
  {path: ':id', component: ProductDetailComponent},
];

const routes: Routes = [
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: 'products', component: ProductPageComponent, children: productsRoutes},
  {path: 'fournisseurs', component: FournisseurListComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    NavigationBarComponent,
    FournisseurListComponent,
    ProductPageComponent,
    FournisseurPageComponent,
    ProductDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule,
    RouterModule,
    RouterModule.forRoot(routes)
  ],
  providers: [{provide: ProductService, useClass: FakeProductService}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
