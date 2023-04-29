import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Answer } from './answer';
import { QuestionService } from './question.service';
import { AnswerService } from './answer.service';

@Component({
  selector: 'answer',
  templateUrl: './answer.component.html'
})
export class AnswerComponent implements OnInit {
  answer_form=new Answer("","","","",-1,"","");
  answers:Answer[];
  constructor(private questionService:QuestionService, private answerService:AnswerService) {
    this.answers = [];
  }
  
  ngOnInit(): void {
    /*
    console.log('hello');
    this.answerService.getAnswers().subscribe((data: Answer[]) => {
      console.log(data);
      this.answers = data;
    });
    */
  }

  onSubmitAnswer(answer_form:any) { 
    console.log(this.questionService.currQuestionId);
    answer_form.question_id = this.questionService.currQuestionId;
    this.answerService.addAnswerToQuestion(new Answer(answer_form.description_answer, answer_form.image_src, answer_form.status,
        answer_form.datetime, answer_form.question_id, answer_form.aapproved_by, answer_form.acreated_by))
        .subscribe((data:Answer)=>{
            console.log(data);
            // this.question = data;
    })
  }
}