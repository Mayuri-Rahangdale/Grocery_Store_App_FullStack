import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GroceryDetailsComponent } from './grocery-details/grocery-details.component';
import { GroceryListComponent } from './grocery-list/grocery-list.component';
import { GroceryAddComponent } from './grocery-add/grocery-add.component';
import { GroceryUpdateComponent } from './grocery-update/grocery-update.component';

const routes: Routes = [
  { path: '', redirectTo: '/groceries', pathMatch: 'full' },
  { path: 'groceries', component: GroceryListComponent },
  { path: 'groceries/add', component: GroceryAddComponent },
  { path: 'groceries/:id', component: GroceryDetailsComponent },
  { path: 'edit/:id', component: GroceryUpdateComponent },
  { path: 'details/:id', component: GroceryDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
