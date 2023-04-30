import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/question';
import { QuestionService } from 'src/app/question.service';


@Component({
    selector: 'pending-questions',
    templateUrl: './pending-questions.html'
})
export class PendingQuestionsComponent implements OnInit
{
    questions:Question[];

    constructor(private questionService:QuestionService) 
    {
        this.questions=[];
    }
    
    ngOnInit()
    {
        this.questionService.getQuestions().subscribe((data: Question[]) => {
            console.log(data);
            this.questions = data;
          });
    }    

    approve(i:number)
    {
        this.questions[i].status='accepted';
        this.questionService.updateQuestion(this.questions[i]).subscribe((data: Question) => {
            console.log(data);
          });
    }

    remove(i:number)
    {
        this.questions[i].status='deleted!!!'; // we should never see this
        this.questionService.updateQuestion(this.questions[i]).subscribe((data: Question) => {
            console.log(data);
            this.questionService.deleteQuestionById(this.questions[i].id).subscribe();  
          });
    }

}