import { Component } from '@angular/core';
import { LoginService } from '../login/login.service';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { ChatService } from 'src/app/chat.service';

@Component({
    selector: 'chat-details',
    templateUrl: './chat-details.component.html'
})
export class ChatDetailsComponent
{

    constructor() {}
        
  
    ngOnInit(): void {
        // this.userService.getUsers().subscribe((data: User[]) => {
        // console.log(data);
        // this.users = data;
        // });
    }
}