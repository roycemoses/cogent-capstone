import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
    selector: 'register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    registerForm:User;
    userTypes:string[];
    
    constructor(private userService:UserService, private router:Router) 
    {
        this.registerForm = new User("", "", "", "", "");
        this.userTypes = ["admin", "user"];
    }

    ngOnInit(): void {

    }

    onSubmitRegister()
    {
        // console.log("registerform: " + registerform.name);
        this.userService.addUser(new User(this.registerForm.name, this.registerForm.userName, 
            this.registerForm.password, this.registerForm.email, 
            this.registerForm.userType));
        
        alert("You have successfully registered!");
        this.router.navigate(['/home']);
    }



}
