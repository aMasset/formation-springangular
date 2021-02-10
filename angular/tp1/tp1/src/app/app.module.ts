import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {ProductListComponent} from './product-list/product-list.component';
import {FormsModule} from '@angular/forms';
import {FakeProductService} from './service/fake-product.service';
import {ProductService} from './service/product-service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NavigationBarComponent} from './navigation-bar/navigation-bar.component';
import {RouterModule, Routes} from '@angular/router';
import { FournisseurListComponent } from './fournisseur-list/fournisseur-list.component';


const routes: Routes = [
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: 'products', component: ProductListComponent},
  {path: 'fournisseurs', component: FournisseurListComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    NavigationBarComponent,
    FournisseurListComponent
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
