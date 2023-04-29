import { Question } from "./question";

export class Answer {
	description_answer:string;
	image_src:string;
    status:string;
	datetime:string;
    question:Question;
    approved_by:string;
    created_by:string;

	constructor(	
    description_answer:string,
	image_src:string,
    status:string,
	datetime:string,
    question:Question,
    approved_by:string,
    created_by:string) {
		this.description_answer=description_answer;
		this.image_src=image_src;
        this.status=status;
		this.datetime=datetime;
        this.question=question;
		this.status=status;
        this.approved_by=approved_by;
		this.created_by=created_by;
	}
	
}