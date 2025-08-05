import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, RouterLink } from '@angular/router';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category';

@Component({
  selector: 'app-category-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterLink],
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {
  categoryForm: FormGroup;
  isEditMode = false;
  categoryId?: number;

  constructor(
    private fb: FormBuilder,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.categoryForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      description: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.categoryId = +params['id'];
        this.categoryService.getCategory(this.categoryId).subscribe(data => {
          this.categoryForm.patchValue({
            name: data.name,
            description: data.description
          });
        });
      }
    });
  }

  onSubmit(): void {
    if (this.categoryForm.invalid) {
      this.categoryForm.markAllAsTouched();
      return;
    }
    const category: Category = this.categoryForm.value;
    if (this.isEditMode) {
      this.categoryService.updateCategory(this.categoryId!, category).subscribe({
        next: () => this.router.navigate(['/categories']),
        error: (err) => console.error('Error al actualizar categoría:', err)
      });
    } else {
      this.categoryService.createCategory(category).subscribe({
        next: () => this.router.navigate(['/categories']),
        error: (err) => console.error('Error al crear categoría:', err)
      });
    }
  }
}
