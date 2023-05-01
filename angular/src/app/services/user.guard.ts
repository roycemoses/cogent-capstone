import { Component, Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from '../app-routing/login/login.service';

@Injectable({
    providedIn: 'root',
  })
export class UserGuard implements CanActivate {
    constructor(private loginService:LoginService,private router:Router)
    {

    }
    
    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot) :Promise<boolean> {
            //this.router.navigate(['/'])
            return new Promise((resolve, reject) => {
                console.log(this.loginService.isLoggedIn);
                // console.log("User type: " + this.login.getUserType());
                if (this.loginService.userType == 'user') {
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