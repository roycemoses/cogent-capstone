import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { QuestionService } from 'src/app/question.service';
import { Question } from 'src/app/question';
import { DatePipe } from '@angular/common';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';
// import { Question.createQuestion }

@Component({
    selector: 'create-question',
    templateUrl: './create-question.component.html',
    styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent
{
    question_form: Question;
    userType:string='';
    //mailtime!:boolean;

    constructor(private questionService:QuestionService, public datePipe:DatePipe, private loginService:LoginService,private router:Router) {
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
    let status = 'pending';
    console.log("hi i added a question to the backend");

    if (this.loginService.userType == 'admin')
        status = 'accepted';

    this.questionService.addQuestion(new Question(questionform.description_question, questionform.image_src, str, 
        status, questionform.topic, questionform.title, [], this.loginService.user.userName, questionform.qapproved_by)).subscribe((data)=>{
          this.questionService.sendEmail(data.id);
          console.log(data.id);
        });
    //this.mailtime = true;
    
    if (this.loginService.userType == 'admin')
        alert("Successfully created a question!\nYou are an admin. Your questions are auto-approved!");
    else
        alert("Successfully created a question!");
        

    if(this.loginService.userType=='admin'){
      this.router.navigate(['/admin-dashboard']);
    }else if(this.loginService.userType=='user'){
      this.router.navigate(['/user-dashboard']);
    }
  }

  url!:any;
  readUrl(event:any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
  
      reader.onload = (event: ProgressEvent) => {
        this.url = (<FileReader>event.target).result;
      }
  
      console.log(reader.readAsDataURL(event.target.files[0]));
      console.log(this.url);
    }
  }
  

  // subMail() {
  //   this.questionService.sendEmail(this.question_form.id);
  //   this.mailtime = false;
  // }

}