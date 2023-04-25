import { Component, OnInit } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    title = 'hi';
    loginForm:Login;
    toggleEditForm:boolean=false;
    token:String;

    constructor(private loginService:LoginService) 
    {
        this.loginForm = new Login();
        this.token = "";
    }

    ngOnInit(): void {
        // this.loginService.getLogins().subscribe((data:Login[])=>{
        //     console.log(data);
        // })
    }

    onSubmit(loginform:any) // update
    {
        console.log(this.loginForm.userName);
        console.log(this.loginForm.password);
        // console.log(loginform.value);

        this.loginService.postRequestForToken(this.loginForm).subscribe((data:String)=>{
            console.log(data.toString());
            this.token = new String(data.toString());
        })

    }

    printToken()
    {
        console.log(this.token);
    }

    goHome()
    {
        this.loginService.getHomeString(this.token.toString()).subscribe((data:String)=>{
            console.log(data.toString());
        })
    }


    refresh()
    {
        window.location.reload();
    }
    delay(ms: number) {
        return new Promise( resolve => setTimeout(resolve, ms) );
    }

}
