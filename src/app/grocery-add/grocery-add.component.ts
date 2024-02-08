import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GroceryService } from '../grocery.service';
import { Grocery } from '../grocery.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GrocerySource } from '../grocery-source';

@Component({
  selector: 'app-grocery-add',
  templateUrl: './grocery-add.component.html',
  styleUrls: ['./grocery-add.component.css'],
})
export class GroceryAddComponent implements OnInit {
  newGroceryForm!: FormGroup;

  states: GrocerySource[] | undefined;

  constructor(
    private router: Router,
    private groceryService: GroceryService,
    private formBuilder: FormBuilder
  ) {}

  initalizedForm(): void {
    this.newGroceryForm = this.formBuilder.group({
      groceryName: ['', Validators.required],
      costPerItem: [0, Validators.required],
      groceryAmounts: this.formBuilder.group({
        itemsAvailable: [0, Validators.required],
      }),
      grocerySource: this.formBuilder.group({
        source_id: [0, Validators.required],
      }),
    });
  }

  // Add the states array to the form
  //this.newGroceryForm.get('grocerySource.stateName')?.setValue(states[0]); // Set a default state
  //this.newGroceryForm.addControl('states', this.formBuilder.array(states));
  //}

  ngOnInit(): void {
    // Additional initialization logic if needed
    this.initalizedForm();
    this.states = this.groceryService.getAllStates();
  }

  addGrocery(): void {
    if (this.newGroceryForm.valid) {
      const newGrocery: Grocery = {
        groceryName: this.newGroceryForm.get('groceryName')?.value,
        costPerItem: this.newGroceryForm.get('costPerItem')?.value,
        groceryAmounts: {
          itemsAvailable: this.newGroceryForm.get(
            'groceryAmounts.itemsAvailable'
          )?.value,
        },
        grocerySource: {
          source_id: this.newGroceryForm.get('grocerySource.source_id')?.value,
        },
      };

      this.groceryService.addGrocery(newGrocery).subscribe({
        next: (data) => {
          console.log('Grocery added successfully:', data);
          this.router.navigate(['/groceries']);
        },
        error: (error) => {
          console.error('Error adding grocery:', error);
        },
      });
    }
  }

  submitForm(): void {
    if (this.newGroceryForm.valid) {
      this.newGroceryForm.patchValue({
        groceryName:
          (this.newGroceryForm.get('groceryName')?.value || '').trim() || 0,
        costPerItem: this.newGroceryForm.get('costPerItem')?.value || 0,
        groceryAmounts: {
          itemsAvailable:
            this.newGroceryForm.get('groceryAmounts.itemsAvailable')?.value ||
            0,
        },
        grocerySource: {
          source_id:
            this.newGroceryForm.get('grocerySource.source_id')?.value || 0,
        },
      });

      const formData = this.newGroceryForm.value;
      console.log('Updated Form Data:', formData);

      // call the addGrocery method
      this.addGrocery();
    }
  }
}
