import { Component, OnInit, Input, Output, Injectable } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { User } from 'src/app/user';
import { Router } from '@angular/router';

@Injectable({
    providedIn: 'root'
})
@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    title = 'hi';

    logins:Login[];
    loginForm:Login;
    token:String;
    loginSuccessful:boolean;
    user:User;


    constructor(private loginService:LoginService, private router:Router) 
    {
        this.logins = [];
        this.loginForm = new Login();
        this.token = "";
        this.loginSuccessful = false;
        this.user = new User(-1, "", "", "", "", "User");
    }

    ngOnInit(): void {
        // this.loginService.getLogins().subscribe((data:Login[])=>{
        //     console.log(data);
        // })
    }

    onSubmitLogin(loginform:any) // update
    {
        console.log(this.loginForm.userName);
        console.log(this.loginForm.password);
        // console.log(loginform.value);
        // this.generateToken(); // promise me you'll finish this one first

        // const generateTokenPromise = new Promise<string>((resolve, reject) => {
        //     this.generateToken(); // promise me you'll finish this one first
        //     if (this.token != '')
        //         resolve(this.token.toString());
        //     else
        //         reject("token has not been generated!");
        // })
        
        
        // generateTokenPromise.then((value) => {
        //     console.log(value);
        // }).catch((error) => {
        //     console.log(error);
        // }).finally(() => {
        //     console.log("The promise is completed.");
        //     this.generateUser(this.loginForm.userName, this.token.toString());
        // })

        // const generateTokenPromise = Promise.resolve(this.generateToken());
        this.generateToken();
        // generateTokenPromise.then(() => this.generateUser(this.loginForm.userName, this.token.toString()));

        // this.generateToken(); // promise me you'll finish this one first
        // this.generateUser(this.loginForm.userName, this.token.toString());

        console.log("this.user.userType: " + this.user.userType);
    }

    generateToken()
    {
        this.loginService.postRequestForToken(this.loginForm).subscribe((data:String)=>{
            console.log(data.toString());
            this.token = new String(data.toString());
            this.generateUser(this.loginForm.userName, this.token.toString());
        })
        // console.log(this.token);
        // return this.token.toString();
    }

    generateUser(userName:string, token:string)
    {
        console.log("are you realasdasd?" + this.token);
        this.loginService.getUser(userName, token).subscribe((data:User)=>{
            console.log(data);
            this.user = data;
            console.log(this.user.userType);
            if (this.user.userType == 'admin')
                this.router.navigate(['/admin-dashboard']);
            else if (this.user.userType == 'user')
                this.router.navigate(['/user-dashboard']);
            console.log(this.user);
        })
    }


    printToken()
    {
        console.log(this.token.toString());
    }

    goHome() // GET Request to the Home Handler
    {
        this.loginService.getHomeString(this.token.toString()).subscribe((data:Object)=>{
            console.log(data.toString());
        })
    }

    getUserType():string {
        return this.user.userType;
    }
    
    @Input() toggleLoginOff:any; toggleAdminDashboardOn:any;
    goToAdminDashboard()
    {
        this.toggleLoginOff();
        this.toggleAdminDashboardOn();
        // @Input() toggleLogin()
    }

}
