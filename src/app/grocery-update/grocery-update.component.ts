import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GroceryService } from '../grocery.service';
import { Grocery } from '../grocery.model';
import { GrocerySource } from '../grocery-source';

@Component({
  selector: 'app-grocery-update',
  templateUrl: './grocery-update.component.html',
  styleUrls: ['./grocery-update.component.css'],
})
export class GroceryUpdateComponent implements OnInit {
  grocery: Grocery = {
    item_id: 0,
    groceryName: '',
    costPerItem: 0,
    groceryAmounts: {
      id: 0,
      itemsAvailable: 0,
      totalCostOfItems: 0,
    },
    grocerySource: {
      source_id: 0,
      stateName: '',
    },
  };

  // grocery!: Grocery;

  source: GrocerySource[] | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private groceryService: GroceryService
  ) {}

  ngOnInit(): void {
    this.loadGrocery();
    this.source = this.groceryService.getAllStates();
  }

  loadGrocery(): void {
    const id = this.route.snapshot.params['id'];
    this.groceryService.getGroceryById(id).subscribe((grocery: Grocery) => {
      this.grocery = grocery;
    });
  }

  updateGrocery(): void {
    if (this.grocery && this.grocery.item_id) {
      this.groceryService
        .updateGrocery(this.grocery.item_id, this.grocery)
        .subscribe(
          () => {
            console.log('Grocery updated successfully:');
            // Additional logic after updating, e.g., navigate to the details page
            this.router.navigate(['/groceries', this.grocery.item_id]);
          },
          (error) => {
            console.error('Error updating grocery:', error);
            // Handle error, show a message, etc.
          }
        );
    } else {
      console.error('Invalid grocery data. Unable to update.');
    }
  }
}
