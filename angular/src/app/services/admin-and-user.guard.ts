import { Component, Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from '../app-routing/login/login.service';

@Injectable({
    providedIn: 'root',
  })
export class AdminAndUserGuard implements CanActivate {
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
                if (this.loginService.userType == 'admin' || this.loginService.userType == 'user') {
                    resolve(true);
                } else {   
                    this.router.navigate(['/error/403']);
                    resolve(false);
                }
                //end of verify
    })
    //end of canActivate
  
  }
}
