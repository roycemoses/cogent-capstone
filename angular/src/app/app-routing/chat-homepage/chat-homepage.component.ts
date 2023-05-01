import { Component } from '@angular/core';
import { LoginService } from '../login/login.service';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { ChatService } from 'src/app/chat.service';

@Component({
    selector: 'chat-homepage',
    templateUrl: './chat-homepage.component.html',
    styleUrls: ['./chat-homepage.component.css']
})
export class ChatHomepageComponent
{
    users!:User[];
    currUserName:string;
    userType!:string;
   

    constructor(private loginService:LoginService, private userService:UserService, private chatService:ChatService) {
        this.currUserName = loginService.user.userName;
        this.userType = loginService.userType;
    }
  
    ngOnInit(): void {
        this.userService.getUsers().subscribe((data: User[]) => {
        console.log(data);
        this.users = data;
        });
    }

    setCurrChatUser(user:User)
    {
        this.chatService.setCurrChatUser(user);
    }

}