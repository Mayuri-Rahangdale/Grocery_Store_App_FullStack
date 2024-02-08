import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GroceryDetailsComponent } from './grocery-details/grocery-details.component';
import { GroceryListComponent } from './grocery-list/grocery-list.component';
import { GroceryAddComponent } from './grocery-add/grocery-add.component';
import { GroceryUpdateComponent } from './grocery-update/grocery-update.component';
import {
  HttpClientModule,
  provideHttpClient,
  withFetch,
} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    GroceryDetailsComponent,
    GroceryListComponent,
    GroceryAddComponent,
    GroceryUpdateComponent,
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
