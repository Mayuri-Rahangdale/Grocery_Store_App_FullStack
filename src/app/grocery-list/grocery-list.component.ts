import { Component, OnInit } from '@angular/core';
import { GroceryService } from '../grocery.service';
import { Grocery } from '../grocery.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css'],
})
export class GroceryListComponent implements OnInit {
  groceries: Grocery[] = [];

  constructor(private router: Router, private groceryService: GroceryService) {}

  ngOnInit(): void {
    this.loadGroceries();
  }

  loadGroceries(): void {
    this.groceryService.getGroceries().subscribe((groceries) => {
      this.groceries = groceries;
    });
  }

  editGrocery(id: number): void {
    this.router.navigate(['/edit', id]);
  }

  deleteGrocery(id: number): void {
    if (confirm('Are you sure you want to delete this grocery?')) {
      this.groceryService.deleteGrocery(id).subscribe(() => {
        // Reload the groceries after deletion
        this.loadGroceries();
      });
    }
  }
}
