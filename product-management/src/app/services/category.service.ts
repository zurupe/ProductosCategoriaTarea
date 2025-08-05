import { Injectable } from '@angular/core';
   import { HttpClient } from '@angular/common/http';
   import { Observable } from 'rxjs';
   import { Category } from '../models/category';

   @Injectable({
     providedIn: 'root'
   })
   export class CategoryService {
     private apiUrl = 'http://localhost:8003/api/categoria';

     constructor(private http: HttpClient) { }

     getCategorias(): Observable<Category[]> {
       return this.http.get<Category[]>(this.apiUrl);
     }

     getCategoria(id: number): Observable<Category> {
       return this.http.get<Category>(`${this.apiUrl}/${id}`);
     }

     createCategoria(category: Category): Observable<Category> {
       return this.http.post<Category>(this.apiUrl, category);
     }

     updateCategoria(id: number, category: Category): Observable<Category> {
       return this.http.put<Category>(`${this.apiUrl}/${id}`, category);
     }

     deleteCategoria(id: number): Observable<void> {
       return this.http.delete<void>(`${this.apiUrl}/${id}`);
     }
   }