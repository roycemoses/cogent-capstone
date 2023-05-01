export class User
{
    public id!:number;
    public name:string;
    public userName:string;
    public password:string;
    public email:string;
    public userType:string;

    constructor(name:string, userName:string, password:string, email:string, userType:string)
    {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

}