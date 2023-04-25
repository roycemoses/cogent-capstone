import { HttpClient, HttpHeaders } from '@angular/common/http'
import { User } from './user';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn:`root`
})
export class UserService
{
    private baseUrl = 'http://localhost:8080/api/users';
    
    constructor (private httpClient:HttpClient) {}

    getUsers():Observable<User[]> {
        return this.httpClient.get<User[]>((`${this.baseUrl}`));
    }

    updateUser(user: User): Observable<User> {
        return this.httpClient.put<User>(this.baseUrl, user);
      }

    deleteUser(id: number): Observable<User> {
        // const url = `${this.baseUrl}/id=${id}`; // DELETE api/heroes/42
        return this.httpClient.delete<User>((`${this.baseUrl}/id=${id}`));
      }

    addUser(user: User): Observable<User> {
        return this.httpClient.post<User>(this.baseUrl, user);
    }

    
}