import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginComponent } from '../login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private login:LoginComponent,private router:Router)
  {

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) :Promise<boolean> {
      
    //this.router.navigate(['/'])
    return new Promise((resolve, reject) => {
    console.log("User type: " + this.login.getUserType());
    if (this.login.getUserType() == 'User' || this.login.getUserType() == 'Admin') {
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
