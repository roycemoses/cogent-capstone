export class Answer {
	description_answer:string;
	image_src:string;
    status:string;
	datetime:string;
    question:number;
    aapproved_by:string;
    acreated_by:string;

	constructor(	
    description_answer:string,
	image_src:string,
    status:string,
	datetime:string,
    question:number,
    aapproved_by:string,
    acreated_by:string) {
		this.description_answer=description_answer;
		this.image_src=image_src;
        this.status=status;
		this.datetime=datetime;
        this.question=question;
		this.status=status;
        this.aapproved_by=aapproved_by;
		this.acreated_by=acreated_by;
	}
	
}