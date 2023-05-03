import { Component, Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from '../app-routing/login/login.service';

@Injectable({
    providedIn: 'root',
  })
export class AdminGuard implements CanActivate {
    constructor(private loginService:LoginService,private router:Router)
    {

    }
    
    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot) :Promise<boolean> {
            //this.router.navigate(['/'])
            return new Promise((resolve, reject) => {
                console.log(this.loginService.isLoggedIn);
                console.log("User type: " + this.loginService.userType);
                if (this.loginService.userType == 'admin') {
                    resolve(true);
                } else {
                    this.router.navigate(['error/403']);
                    resolve(false);
                }
                //end of verify
    })
    //end of canActivate
  
  }
}
