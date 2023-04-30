import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { Question } from 'src/app/question';
import { DatePipe } from '@angular/common';
// import { Question.createQuestion }

@Component({
    selector: 'create-question',
    templateUrl: './create-question.component.html'
})
export class CreateQuestionComponent
{
    question_form: Question;

    constructor(private questionService:QuestionService, public datePipe:DatePipe) {

    this.question_form=new Question("","","","","","",[],"","");

  }
  
//   ngOnInit(): void {
//     console.log('hello');
//     this.questionService.getQuestions().subscribe((data: Question[]) => {
//       console.log(data);
//       this.questions = data;
//     });
//   }


  onSubmitQuestion(questionform:any) {
    let currentDateTime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss');
    let str = String(currentDateTime);
    console.log("hi i added a question to the backend");
    this.questionService.addQuestion(new Question(questionform.description_question, questionform.image_src, str, 
        questionform.status, questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by)).subscribe();
  }

}