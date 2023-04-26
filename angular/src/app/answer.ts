export class Answer {
	description_answer:string;
	image_src:string;
	datetime:string;
	status:string;
    acreated_by:string;
    aapproved_by:string;

	constructor(	
    description_answer:string,
	image_src:string,
	datetime:string,
	status:string,
    
    acreated_by:string,
    aapproved_by:string) {
		this.description_answer=description_answer;
		this.image_src=image_src;
		this.datetime=datetime;
		this.status=status;
		this.acreated_by=acreated_by;
		this.aapproved_by=aapproved_by;
	}
	
}