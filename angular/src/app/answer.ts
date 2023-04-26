export class Answer {
	description_answer:string;
	image_src:string;
	datetime:string;
	status:string;
    //idk for the answers list
    qcreated_by:string;
    qapproved_by:string;

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
		this.qcreated_by=acreated_by;
		this.qapproved_by=aapproved_by;
	}
	
}