import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Login } from './login';
import { Observable, ObservedValueOf } from 'rxjs';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
    providedIn:'root'
})
export class LoginService
{
    private baseUrl = 'http://localhost:8080';
    
    constructor (private httpClient:HttpClient) {}
    
    getLogins():Observable<Object> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTY4MjU2MTUzNCwiaWF0IjoxNjgyNTI1NTM0fQ.U6UkO2moV8JVvISiKrDwH7RN27gjOcJUsRsO0YNVyAc').set('ResponseType','text')
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        
        return this.httpClient.get(`${this.baseUrl}`, {'headers':headers, responseType:'text'});
    }

    postRequestForToken(login:Login):Observable<String> {
        // console.log(this.httpClient.post<String>(this.baseUrl, login));
        return this.httpClient.post(`${this.baseUrl}/authenticate`, login, { responseType: 'text' });
        // this.http.post(url, body, { responseType: 'text' }).subscribe();
    };

    getHomeString(token:string):Observable<Object> 
    {        
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

        return this.httpClient.get(`${this.baseUrl}/test`, {'headers':headers, responseType:'text'});
    }

    getUser(userName:string):Observable<User> 
    {
        // const headers= new HttpHeaders()
        //     .set('Access-Control-Allow-Origin', '*');

        const headerDict = {
            'Access-Control-Allow-Origin': '*'
        };
            
        const requestOptions = {                                                                                                                                                                                 
            headers: new Headers(headerDict), 
        };
            

        return this.httpClient.get<User>((`${this.baseUrl}/getbyname=${userName}`))
    }

    // getLogins():Observable<Login[]> {
    //     return this.httpClient.get<Login[]>((`${this.baseUrl}`));
    // }

    // updateLogin(login: Login): Observable<Login> {
    //     return this.httpClient.put<Login>(this.baseUrl, login);
    //   }

    // deleteLogin(id: number): Observable<Login> {
    //     // const url = `${this.baseUrl}/id=${id}`; // DELETE api/heroes/42
    //     return this.httpClient.delete<Login>((`${this.baseUrl}/id=${id}`));
    //   }

    // addLogin(login: Login): Observable<Login> {
    //     return this.httpClient.post<Login>(this.baseUrl, login);
    // }

    
}