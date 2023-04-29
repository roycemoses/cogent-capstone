import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Answer } from './answer';
import { QuestionService } from './question.service';
import { AnswerService } from './answer.service';
import { QuestionDetailsService } from './app-routing/question-details/question-details.service';
import { Question } from './question';
import { LoginService } from './app-routing/login/login.service';
import { Routes, RouterModule, Router } from '@angular/router';

@Component({
  selector: 'answer',
  templateUrl: './answer.component.html'
})
export class AnswerComponent implements OnInit {
  answer_form=new Answer("","","","",new Question("","","","","","",[],"",""),"","");
  answers:Answer[];
  constructor(private questionService:QuestionService, private questionDetailsService:QuestionDetailsService,
    private answerService:AnswerService, private loginService:LoginService, private router:Router) {
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
    console.log(this.loginService.user.userName);
    console.log(typeof answer_form.acreated_by);
    this.answerService.addAnswerToQuestion(new Answer(answer_form.description_answer, answer_form.image_src, answer_form.status,
        answer_form.datetime, this.questionDetailsService.question, answer_form.approved_by, this.loginService.user.userName))
        .subscribe((data:Answer)=>{
            console.log(data);
            // this.question = data;
    })

    alert("Your answer has succesfully been submitted!");
    this.router.navigate(['/admin-dashboard']);
  }

//   answerSubmittedAlert()
//   {
//     alert("Your answer has succesfully been submitted!");
//     // import { Routes, RouterModule } from '@angular/router';
//     // this.router.navigate(['/admin-dashboard']);
//     // routerLinkActive="active" routerLink="/admin-dashboard"
//   }
}