import { Component, OnInit } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { QuestionDetailsService } from './question-details.service';
import { Question } from 'src/app/question';
import { Answer } from 'src/app/answer';
import { AnswerService } from 'src/app/answer.service';
import { LoginService } from '../login/login.service';


@Component({
    selector: 'question-details',
    templateUrl: './question-details.html',
    styleUrls:['./question-details.css']
})
export class QuestionDetailsComponent implements OnInit
{
    question_id:number;
    question!:Question;
    answers!:Answer[];
    userType:string='';
    constructor(private questionService:QuestionService, private questionDetailsService:QuestionDetailsService, private answerService:AnswerService,
        private loginService:LoginService) 
    {
        this.userType = this.loginService.userType;
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