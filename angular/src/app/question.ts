import { Answer } from "./answer";

export class Question {
    id!:number;
	description_question:string;
	image_src:string;
	datetime:string;
	status:string;
	topic:string;
	title:string;
    answers:Answer[];
    qcreated_by:string;
    qapproved_by:string;

	constructor(description_question:string, image_src:string, datetime:string, status:string, 
        topic:string, title:string, answers:Answer[], qcreated_by:string, qapproved_by:string) 
    {
		this.description_question=description_question;
		this.image_src=image_src;
		this.datetime=datetime;
		this.status=status;
		this.topic=topic;
		this.title=title;
		this.answers=answers;
		this.qcreated_by=qcreated_by;
		this.qapproved_by=qapproved_by;
	}
	
}

