import { Component, OnInit } from '@angular/core';
import { Answer } from 'src/app/answer';
import { AnswerService } from 'src/app/answer.service';


@Component({
    selector: 'pending-answers',
    templateUrl: './pending-answers.html',
    styleUrls: ['./pending-answers.css']
})
export class PendingAnswersComponent implements OnInit
{
    answers:Answer[];
    pending!:number;

    constructor(private answerService:AnswerService) 
    {
        this.answers=[];
    }
    
    ngOnInit()
    {
        this.answerService.getAllAnswers().subscribe((data: Answer[]) => {
            console.log(data);
            this.answers = data;
            this.pending=0;
            for(let i=0;i<this.answers.length;i++){
                console.log(this.pending);
                if(this.answers[i].status=='pending'){
                    this.pending=this.pending+1;
                }
              }
              console.log(this.answers);
              console.log("Pending"+this.pending);
          });
    }    

    approve(i:number)
    {
        this.answers[i].status='accepted';
        this.answerService.updateAnswer(this.answers[i]).subscribe((data: Answer) => {
            console.log(data);
            this.ngOnInit();
          });
    }

    remove(i:number)
    {
        if (confirm("Are you sure you want to delete this answer? (created by " + this.answers[i].created_by + ")?"))
        {
            this.answers[i].status='deleted!!!'; // we should never see this
            this.answerService.updateAnswer(this.answers[i]).subscribe((data: Answer) => {
                console.log(data);
                this.answerService.deleteAnswerById(this.answers[i].id).subscribe();  
                this.ngOnInit(); // correct placement
            });
        }
    }

}