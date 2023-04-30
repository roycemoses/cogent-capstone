import { HttpClient, HttpHeaders } from '@angular/common/http'
import { User } from './user';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Login } from './app-routing/login/login';

@Injectable({
    providedIn:`root`
})
export class UserService
{
    private baseUrl = 'http://localhost:8080';
    
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

    addUser(user: User) {
        // const token = this.httpClient.get
        this.httpClient.post(`${this.baseUrl}/authenticate`, new Login("none","none"), { responseType: 'text' }).subscribe((data:String)=>{
            const token = data.toString();
            console.log("token:" + token);
            const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + token)
            .set('responseType', 'text')
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

            console.log(user);
            this.httpClient.post<User>((`${this.baseUrl}/user/adduser`), user, {"headers": headers}).subscribe((data:User)=>{
                console.log(data);
            });
            
            return this.httpClient.post<User>((`${this.baseUrl}/user/adduser`), user, {"headers": headers});
        })
    }

    
}