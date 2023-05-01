import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';
import { LoginService } from './app-routing/login/login.service';
import { User } from './user';
import { Chat } from './chat';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

    currChatUser!:User;

    private baseUrl = "http://localhost:8080/chat";
    constructor(private httpClient: HttpClient, private loginService:LoginService) { }

    setCurrChatUser(user:User)
    {
        this.currChatUser = user;
    }

    getAllMessagesBetweenUsers(user:User, chatUser:User):Observable<Chat[]>
    {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('responseType', 'text')
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

        return this.httpClient.get<Chat[]>((`${this.baseUrl}/getAllMessagesBetweenUsers/`+user.userName+`/`+chatUser.userName), {'headers':headers});
    }

    addMessage(chat:Chat):Observable<Chat>
    {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('responseType', 'text')
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');

        return this.httpClient.post<Chat>((`${this.baseUrl}/addMessage`), chat, {'headers':headers});
    }

}