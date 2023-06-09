import { Injectable } from '@angular/core';

import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from '../models/User'

const httpOptions = {
  headers: new HttpHeaders ({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class UsersService {
  private REST_API_SERVER = "http://localhost:8081/be/";

  constructor(private httpClient: HttpClient) { }

  public getUsers() {
    const url = this.REST_API_SERVER + "/users";
    return this.httpClient.get<any>(url, httpOptions).pipe(catchError(this.handleError));
  }

  public addUser(data: User) {
    const url = this.REST_API_SERVER + "/add-user";
    return this.httpClient.post<any>(url, data, httpOptions).pipe(catchError(this.handleError));
  }

  public deleteUser(userId: number) {
    const url = this.REST_API_SERVER + "/delete-user/" + userId;
    return this.httpClient.delete<any>(url).pipe(catchError(this.handleError));
  }

  public getUserById(id: number) {
    const url = this.REST_API_SERVER + "/user/" + id;
    return this.httpClient.get<any>(url, httpOptions).pipe(catchError(this.handleError));
  }

  public updateUser(id: number, data: User) {
    const url = this.REST_API_SERVER + "/update-user/" + id;
    return this.httpClient.put<any>(url, data, httpOptions).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(`Backend retunred code ${error.status}, ` + `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.'
    )
  }
}
