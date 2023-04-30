import { Component, Injectable } from '@angular/core';
import { LoginService } from './app-routing/login/login.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'user-management-app';
    userType:string = '';

    constructor()
    {

    }
}
