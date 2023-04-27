// import { Component, OnInit } from '@angular/core';
// import { User } from './user';
// import { UserService } from './user.service';

// @Component({
//     selector: 'user',
//     templateUrl: './user.component.html',
//     styleUrls: ['./user.component.css']
// })
// export class UserComponent implements OnInit {
//     title = 'user-management-app';

//     users:User[];
//     userAddForm:User;
//     userEditForm:User;
//     currUser:User;
//     currUserID:number;
//     toggleEditForm:boolean=false;

//     constructor(private userService:UserService) 
//     {
//         this.users = [];
//         this.userAddForm = new User();
//         this.userEditForm = new User();
//         this.currUser = new User();
//         this.currUserID = 0;
//     }

//     ngOnInit(): void {
//         this.userService.getUsers().subscribe((data:User[])=>{
//             console.log(data);
//             this.users = data;
//         })
//     }

//     edit(id:number)
//     {
//         this.currUserID = id;
//         this.toggleEditForm=true;   
//     }

//     onSubmitEdit(adduserform:any) // update
//     {
//         this.currUser.id = this.currUserID;
//         this.currUser.name = adduserform.value.name;
//         this.currUser.age = adduserform.value.age;
//         this.currUser.salary = adduserform.value.salary;

//         console.log(adduserform.value);

//         this.toggleEditForm=false;
//         this.userService.updateUser(this.currUser).subscribe();
//         this.userService.getUsers();
//         this.refresh();
//     }

//     delete(id:number)
//     {
//         this.userService.deleteUser(id).subscribe();
//         this.userService.getUsers();
//         this.refresh();
//     }


//     onSubmitAdd(adduserform:any)
//     {
//         this.currUser.id = adduserform.value.id;
//         this.currUser.name = adduserform.value.name;
//         this.currUser.age = adduserform.value.age;
//         this.currUser.salary = adduserform.value.salary;

//         console.log(adduserform.value);

//         this.userService.addUser(this.currUser).subscribe();
//         this.userService.getUsers();
//         this.refresh();
//     }

//     refresh()
//     {
//         window.location.reload();
//     }

//     resetForm()
//     {
//         this.userAddForm = new User();
//         this.userService.getUsers();
//         this.refresh();
//     }
// }
