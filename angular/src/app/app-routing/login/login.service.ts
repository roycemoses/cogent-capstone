import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Login } from './login';
import { BehaviorSubject, Observable, ObservedValueOf } from 'rxjs';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { User } from 'src/app/user';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import * as myGlobals from '../../globals';

@Injectable({
    providedIn:'root'
})
export class LoginService
{
    public isLoggedIn:boolean = false;
    public userType:string = "";
    public token:string = "";
    public user!:User;
    private baseUrl = 'http://' + myGlobals.ip + ':8080';
    showErrorMessage!:boolean;
    
    constructor (private httpClient:HttpClient,private router:Router) {}
    
    getLogins():Observable<Object> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        
        return this.httpClient.get(`${this.baseUrl}`, {'headers':headers, responseType:'text'});
    }

    postRequestForToken(login:Login):Observable<String> {
        // console.log(this.httpClient.post<String>(this.baseUrl, login));
        this.httpClient.post(`${this.baseUrl}/authenticate`, login, { responseType: 'text' }).subscribe((data:String)=>{
            this.isLoggedIn = true;
            this.token = data.toString();
        },
        (error)=>{
            this.showErrorMessage=true;
        alert("Login failed try again")})

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
        
        console.log(token);

        return this.httpClient.get(`${this.baseUrl}/test`, {'headers':headers, responseType:'text'});
    }


    getUser(userName:string, token:string):Observable<User> 
    {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');            

        console.log(token);
        this.httpClient.get<User>((`${this.baseUrl}/user/getbyname/${userName}`), {'headers':headers}).subscribe((data:User)=>{
            console.log("hey, it's data: " + data.userType);
            this.userType = data.userType;
            // this.appComponent.userType = data.userType;
            // console.log("this.appComponent.userType: " + this.appComponent.userType);
            this.user = data;
            if (this.user.userType == 'admin')
                this.router.navigate(['/admin-dashboard']);
            else if (this.user.userType == 'user')
                this.router.navigate(['/user-dashboard']);
            console.log(this.user);
            console.log("show error "+this.showErrorMessage);
        },
        (error)=>{this.showErrorMessage=true;})

        return this.httpClient.get<User>((`${this.baseUrl}/user/getbyname/${userName}`), {'headers':headers});
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