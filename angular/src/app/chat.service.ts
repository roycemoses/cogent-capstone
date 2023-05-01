import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';
import { LoginService } from './app-routing/login/login.service';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

    currChatUser!:User;

    private baseUrl = "http://localhost:8080/user";
    constructor(private httpClient: HttpClient, private loginService:LoginService) { }

    setCurrChatUser(user:User)
    {
        this.currChatUser = user;
    }

}