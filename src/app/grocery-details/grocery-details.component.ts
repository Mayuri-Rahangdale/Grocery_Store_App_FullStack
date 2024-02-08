import { Component, Input, OnInit } from '@angular/core';
import { Grocery } from '../grocery.model';
import { GroceryService } from '../grocery.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-grocery-details',
  templateUrl: './grocery-details.component.html',
  styleUrls: ['./grocery-details.component.css'],
})
export class GroceryDetailsComponent implements OnInit {
  @Input()
  grocery!: Grocery;

  constructor(
    private route: ActivatedRoute,
    private groceryService: GroceryService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadGroceryDetails();
  }

  loadGroceryDetails(): void {
    // Use this.route instead of route
    const id = this.route.snapshot.params['id'];
    this.groceryService.getGroceryById(id).subscribe((grocery: Grocery) => {
      this.grocery = grocery;
    });
  }
}
