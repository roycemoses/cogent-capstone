import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, 
RouterStateSnapshot, Router } from '@angular/router';
import { LoginComponent } from '../app-routing/login/login.component';
import { LoginService } from '../app-routing/login/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private loginService:LoginService,private router:Router)
  {

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) :Promise<boolean> {
      
    //this.router.navigate(['/'])
    return new Promise((resolve, reject) => {
    console.log("User type: " + this.loginService.userType);
    if (this.loginService.userType == 'user' || this.loginService.userType == 'admin') {
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
