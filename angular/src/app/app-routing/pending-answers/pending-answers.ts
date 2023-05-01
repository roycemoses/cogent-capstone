import { Component, OnInit } from '@angular/core';
import { Answer } from 'src/app/answer';
import { AnswerService } from 'src/app/answer.service';


@Component({
    selector: 'pending-answers',
    templateUrl: './pending-answers.html'
})
export class PendingAnswersComponent implements OnInit
{
    answers:Answer[];

    constructor(private answerService:AnswerService) 
    {
        this.answers=[];
    }
    
    ngOnInit()
    {
        this.answerService.getAllAnswers().subscribe((data: Answer[]) => {
            console.log(data);
            this.answers = data;
          });
    }    

    approve(i:number)
    {
        this.answers[i].status='accepted';
        this.answerService.updateAnswer(this.answers[i]).subscribe((data: Answer) => {
            console.log(data);
          });
    }

    remove(i:number)
    {
        this.answers[i].status='deleted!!!'; // we should never see this
        this.answerService.updateAnswer(this.answers[i]).subscribe((data: Answer) => {
            console.log(data);
            this.answerService.deleteAnswerById(this.answers[i].id).subscribe();  
          });
    }

}