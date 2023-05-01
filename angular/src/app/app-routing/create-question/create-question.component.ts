import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { Question } from 'src/app/question';
import { DatePipe } from '@angular/common';
import { LoginService } from '../login/login.service';
// import { Question.createQuestion }

@Component({
    selector: 'create-question',
    templateUrl: './create-question.component.html'
})
export class CreateQuestionComponent
{
    question_form: Question;
    userType:string='';
    //mailtime!:boolean;

    constructor(private questionService:QuestionService, public datePipe:DatePipe, private loginService:LoginService) {
        this.userType = loginService.userType;
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
        'pending', questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by)).subscribe((data)=>{
          this.questionService.sendEmail(data.id);
          console.log(data.id);
        });
    //this.mailtime = true;
    
  }

  // subMail() {
  //   this.questionService.sendEmail(this.question_form.id);
  //   this.mailtime = false;
  // }

}