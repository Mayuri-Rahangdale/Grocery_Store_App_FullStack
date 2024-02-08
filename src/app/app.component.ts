import { Component, OnInit } from '@angular/core';
import { GroceryService } from './grocery.service';
import { Grocery } from './grocery.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  groceries: Grocery[] = []; // Initialize as an empty array

  constructor(private groceryService: GroceryService) {}

  ngOnInit() {
    // Load groceries from a service when the component initializes
    this.groceryService.getGroceries().subscribe((data) => {
      this.groceries = data;
    });
  }

  fetchData(): void {
    fetch('http://localhost:8080/api/groceries')
      .then((response: { ok: any; json: () => any }) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data: any) => {
        console.log(data);
      })
      .catch((error: any) => {
        console.error('There was a problem with the fetch operation:', error);
      });
  }
}
