import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Grocery } from './grocery.model';
import { GrocerySource } from './grocery-source';
import { SOURCE } from './source';

@Injectable({
  providedIn: 'root',
})
export class GroceryService {
  private apiUrl = 'http://localhost:8080/api/groceries';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  getGroceries(): Observable<Grocery[]> {
    return this.http
      .get<Grocery[]>(this.apiUrl)
      .pipe(catchError(this.handleError));
  }

  getGroceryById(id: number): Observable<Grocery> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Grocery>(url).pipe(
      catchError((error: HttpErrorResponse) => {
        console.error('Error fetching grocery by ID:', error);
        return throwError('Unable to fetch grocery details.');
      })
    );
  }

  addGrocery(grocery: Grocery): Observable<Grocery> {
    return this.http
      .post<Grocery>(this.apiUrl, grocery, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  getAllStates(): GrocerySource[] {
    return SOURCE;
  }

  updateGrocery(id: number, updatedGrocery: Grocery): Observable<Grocery> {
    const url = `${this.apiUrl}/${id}`;
    return this.http
      .put<Grocery>(url, updatedGrocery, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  deleteGrocery(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http
      .delete<void>(url, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.error('An error occurred:', error);
    return throwError(() =>
      of('Something went wrong. Please try again later.')
    );
  }
}
