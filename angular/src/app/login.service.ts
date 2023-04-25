import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Login } from './login';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn:'root'
})
export class LoginService
{
    private baseUrl = 'http://localhost:8080/authenticate';
    
    constructor (private httpClient:HttpClient) {}

    postRequestForToken(login:Login):Observable<String> {
        // console.log(this.httpClient.post<String>(this.baseUrl, login));
        return this.httpClient.post(this.baseUrl, login, { responseType: 'text' });
        // this.http.post(url, body, { responseType: 'text' }).subscribe();
    };

    getHomeString(token:string):Observable<String>
    {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + token)
            .set('Access-Control-Allow-Origin', '*');
            // .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            // .set('Access-Control-Allow-Headers', 'Origin, Content-Type, X-Auth-Token');
        
        return this.httpClient.get<String>(this.baseUrl, {"headers" : headers});
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