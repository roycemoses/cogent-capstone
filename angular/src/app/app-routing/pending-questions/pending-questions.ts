import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/question';
import { QuestionService } from 'src/app/question.service';


@Component({
    selector: 'pending-questions',
    templateUrl: './pending-questions.html',
    styleUrls: ['./pending-questions.css']
})
export class PendingQuestionsComponent implements OnInit
{
    questions:Question[];
    pending!:number;

    constructor(private questionService:QuestionService) 
    {
        this.questions=[];
    }
    
    ngOnInit()
    {
        this.questionService.getQuestions().subscribe((data: Question[]) => {
            console.log(data);
            this.questions = data;
            for(let i=0;i<this.questions.length;i++){
                console.log(i);
                if(this.questions[i].status=='pending'){
                    this.pending=this.pending+1;
                }
              }
              console.log(this.questions);
              console.log("Pending"+this.pending);
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
        if (confirm("Are you sure you want to delete " + this.questions[i].title + " (created by " + this.questions[i].qcreated_by + ") ?"))
        {
            this.questions[i].status='deleted!!!'; // we should never see this
            this.questionService.updateQuestion(this.questions[i]).subscribe((data: Question) => {
                console.log(data);
                this.questionService.deleteQuestionById(this.questions[i].id).subscribe();  
            });
        }
    }

}