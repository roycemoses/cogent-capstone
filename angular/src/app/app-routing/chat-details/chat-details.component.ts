import { Component } from '@angular/core';
import { LoginService } from '../login/login.service';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { ChatService } from 'src/app/chat.service';
import { Chat } from 'src/app/chat';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'chat-details',
    templateUrl: './chat-details.component.html',
    styleUrls: ['./chat-details.component.css']
})
export class ChatDetailsComponent
{

    user!:User;
    chatUser!:User; // incoming chat user
    chats!:Chat[];
    chat_form:Chat;
    userType:string;

    constructor(private loginService:LoginService, private chatService:ChatService, public datePipe:DatePipe) {
        this.user = loginService.user;
        this.chatUser = chatService.currChatUser;
        this.chat_form = new Chat("", "", "", "");
        this.userType = this.loginService.userType;
    }
  
    ngOnInit(): void {
        this.chatService.getAllMessagesBetweenUsers(this.user, this.chatUser).subscribe((data: Chat[]) => {
            console.log(data);
            this.chats = data;
        });
    }

    onSubmitChat()
    {
        let currentDateTime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss');
        let str = String(currentDateTime);

        this.chatService.addMessage(new Chat(this.user.userName, this.chatUser.userName, str, this.chat_form.message)).subscribe((data:Chat) => {
            console.log(data);
            this.chat_form.message = "";
            this.ngOnInit();
        });
    }


}