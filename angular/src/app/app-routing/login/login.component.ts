import { Component, OnInit, Input, Output } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { User } from 'src/app/user';

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


    constructor(private loginService:LoginService) 
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
        this.generateToken();
        // this.generateUser(this.loginForm.userName);
    }

    generateToken()
    {
        this.loginService.postRequestForToken(this.loginForm).subscribe((data:String)=>{
            console.log(data.toString());
            this.token = new String(data.toString());
        })
    }

    generateUser(userName:string)
    {
        this.loginService.getUser(userName).subscribe((data:User)=>{
            console.log(data);
            this.user = data;
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