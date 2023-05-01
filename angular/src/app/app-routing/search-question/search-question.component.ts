import { Component } from '@angular/core';
import { Question } from 'src/app/question';
import { QuestionService } from 'src/app/question.service';

@Component({
    selector: 'search-question',
    templateUrl: './search-question.component.html'
})
export class SearchQuestionComponent 
{
    questions!:Question[];
    query:string="";
    topic:string="";

    constructor(private questionService:QuestionService) {
        
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
