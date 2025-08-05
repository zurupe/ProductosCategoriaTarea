import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list';
import { ProductFormComponent } from './components/product-form/product-form';
import { CategoryListComponent } from './components/category-list/category-list';
import { CategoryFormComponent } from './components/category-form/category-form';

export const routes: Routes = [
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: 'products', component: ProductListComponent },
  { path: 'product/add', component: ProductFormComponent },
  { path: 'product/edit/:id', component: ProductFormComponent },
  { path: 'categories', component: CategoryListComponent },
  { path: 'category/add', component: CategoryFormComponent },
  { path: 'category/edit/:id', component: CategoryFormComponent }
];