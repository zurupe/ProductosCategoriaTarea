import { Routes } from '@angular/router';
import { ProductList } from './components/product-list/product-list';
import { ProductForm } from './components/product-form/product-form';
import { CategoryList } from './components/category-list/category-list';
import { CategoryForm } from './components/category-form/category-form';

export const routes: Routes = [
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: 'products', component: ProductList },
  { path: 'product/add', component: ProductForm },
  { path: 'product/edit/:id', component: ProductForm },
  { path: 'categories', component: CategoryList },
  { path: 'category/add', component: CategoryForm },
  { path: 'category/edit/:id', component: CategoryForm }
];
