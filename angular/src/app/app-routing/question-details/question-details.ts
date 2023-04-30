import { Component, OnInit } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { QuestionDetailsService } from './question-details.service';
import { Question } from 'src/app/question';
import { Answer } from 'src/app/answer';
import { AnswerService } from 'src/app/answer.service';


@Component({
    selector: 'question-details',
    templateUrl: './question-details.html'
})
export class QuestionDetailsComponent implements OnInit
{
    question_id:number;
    question!:Question;
    answers!:Answer[];
    constructor(private questionService:QuestionService, private questionDetailsService:QuestionDetailsService, private answerService:AnswerService) 
    {
        this.question_id = this.questionService.currQuestionId;
        this.question = new Question("","","","","","",[],"","");
    }

    ngOnInit()
    {
        this.questionDetailsService.getQuestionById(this.question_id).subscribe((data:Question)=>{
            console.log(data);
            this.question = data;
        })
        
        this.answerService.getAllAnswersByQuestionId(this.question_id).subscribe((data:Answer[])=>{
            console.log(data);
            this.answers = data;
        })
    }    

}