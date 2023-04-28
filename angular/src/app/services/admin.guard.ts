import { Component, Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from '../app-routing/login/login.service';

@Injectable({
    providedIn: 'root',
  })
export class AdminGuard implements CanActivate {
constructor(/*private httpClient:HttpClient,*/ private loginService:LoginService,private router:Router)
{

}
private baseUrl = 'http://localhost:8080';
    
    // getLogins():Observable<Object> {
    //     const headers= new HttpHeaders()
    //         .set('Authorization', 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTY4MjU2MTUzNCwiaWF0IjoxNjgyNTI1NTM0fQ.U6UkO2moV8JVvISiKrDwH7RN27gjOcJUsRsO0YNVyAc').set('ResponseType','text')
    //         .set('Access-Control-Allow-Origin', '*')
    //         .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
    //         .set('Access-Control-Allow-Headers','*');
        
    //     return this.httpClient.get(`${this.baseUrl}`, {'headers':headers, responseType:'text'});
    // }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot) :Promise<boolean> {
            //this.router.navigate(['/'])
            return new Promise((resolve, reject) => {
                
                // Getting all users that are logged in (should only be one)
                // httpRequest
                // Check if an entry was returned
                    // if null, go to login
                    // else, check its user type ("Admin"?)
                

                console.log(this.loginService.isLoggedIn);
                // console.log("User type: " + this.login.getUserType());
                if (this.loginService.userType == 'admin') {
                    resolve(true);
                } else {    
                    resolve(false);
                    this.router.navigate(['/error'])
                }
                //end of verify
    })
    //end of canActivate
  
  }
}
