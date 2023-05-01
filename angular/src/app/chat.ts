export class Chat {
    id!:number;
	fromUser:string;
	toUser:string;
    message:string;
	datetime:string;

	constructor(fromUser:string, toUser:string, datetime:string, message:string) 
    {
		this.fromUser = fromUser;
        this.toUser= toUser;
        this.message = message;
        this.datetime = datetime;
	}
	
}

