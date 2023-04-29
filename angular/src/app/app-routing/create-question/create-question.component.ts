import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { Question } from 'src/app/question';
// import { Question.createQuestion }

@Component({
    selector: 'create-question',
    templateUrl: './create-question.component.html'
})
export class CreateQuestionComponent
{
    question_form: Question;
    displayForm:boolean = false;

    constructor(private questionService:QuestionService) {

    this.question_form=new Question("","","","","","",[],"","", false);    

  }
  
//   ngOnInit(): void {
//     console.log('hello');
//     this.questionService.getQuestions().subscribe((data: Question[]) => {
//       console.log(data);
//       this.questions = data;
//     });
//   }


  @Output()
  newQuestionEvent = new EventEmitter<Question>();
  onSubmitQuestion(questionform:any) {
    console.log("emitting?");
    this.newQuestionEvent.emit(new Question(questionform.description_question, questionform.image_src, 
                                questionform.datetime, questionform.status, questionform.topic, questionform.title, 
                                [], questionform.qcreated_by, questionform.qapproved_by, questionform.toggleAnswer));
    // this.questions.push(new Question(questionform.description_question, questionform.image_src, questionform.datetime, questionform.status, questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by, questionform.toggleAnswer) );
    // console.log(this.question_form);
  }

  showForm()
  {
    this.displayForm = true;
  }

}