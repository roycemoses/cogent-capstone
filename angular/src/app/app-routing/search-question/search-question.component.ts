import { Component } from '@angular/core';
import { Question } from 'src/app/question';
import { QuestionService } from 'src/app/question.service';
import { LoginService } from '../login/login.service';

@Component({
    selector: 'search-question',
    templateUrl: './search-question.component.html',
    styleUrls: ['./search-question.component.css']
})
export class SearchQuestionComponent 
{
    questions!:Question[];
    query:string="";
    topic:string="";
    userType!:string;

    constructor(private questionService:QuestionService,private loginService:LoginService) {
        this.userType=loginService.userType;
    }

    ngOnInit() {
        this.questionService.getQuestions().subscribe((data)=> {
            this.questions=data;
        });
    }

    // search() 
    // {
    //     // this.questionService.getQuestionbyTopic(topic:string).subscribe((data)=>{
    //     // })
        
    // }
    setCurrQuestionId(id:number)
    { 
      this.questionService.setCurrQuestionId(id);
    }
    
}
