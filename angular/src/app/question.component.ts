import { Component, OnInit } from '@angular/core';
import { QuestionService } from './question.service';
import { Question } from './question';
import { Answer } from './answer';
import { CreateQuestionComponent } from './app-routing/create-question/create-question.component';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'question',
  templateUrl: './question.component.html'
})

export class QuestionComponent implements OnInit {
    question_form: Question;
    // answers1: Answer[];
    // answers2: Answer[];
    questions: Question[];

    addQuestion(newQuestion:Question)
    {
        console.log("added a question to questions[]");
        this.questions.push(newQuestion);
    }
    // NOTES: 
    // * Questions array doesn't update properly across different routes....
    // * Output decorator & Emit is working
    // * 

    constructor(private questionService:QuestionService, public datePipe:DatePipe) {

        let currentDateTime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss');
        console.log(currentDateTime);
        this.question_form=new Question("","","","","","",[],"","");    


        // this.answers1 = [
        //   new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi"),
        //   new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi")
        // ];

        // this.answers2 = [
        //   new Answer("i am bad at sqrts?", "test_image2.png", "4/4/2004 22:22", "accepted","ok", "hi"),
        //   new Answer("i am bad at sqrts", "test_image2.png", "4/4/2004 22:22", "denied","ok", "hi")
        // ];

        // this.questions = [
        //   new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "denied", "math", "what is the sqrt4",[], "ok", "hi", false),
        //   new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4",this.answers2, "ok", "hi", false)
        // ];
        this.questions = []; // updated in backend on ngOnInit

  }
  
  ngOnInit(): void {
    console.log('hello, I am in the question component!!!');
    this.questionService.getQuestions().subscribe((data: Question[]) => {
      console.log(data);
      this.questions = data;
    });
  }

  onSubmitQuestion(questionform:any) {
    // this.questions.push(new Question(questionform.description_question, questionform.image_src, questionform.datetime, questionform.status, questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by, questionform.toggleAnswer) );
    console.log(this.question_form);
    // this.questionService.addQuestion(new Question(questionform.description_question, questionform.image_src, questionform.datetime, questionform.status, questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by, questionform.toggleAnswer)).subscribe((data:Question) => {
    //     console.log("hi i added a question to the backend");
    //     console.log(data);
    // })
    this.questionService.addQuestion(new Question(questionform.description_question, questionform.image_src, questionform.datetime, 
        questionform.status, questionform.topic, questionform.title, [], questionform.qcreated_by, questionform.qapproved_by)).subscribe();

    console.log(this.questions);
    console.log("hi i added a question to the backend");
    // console.log(this.questions[0].getId());
    
  }

  setCurrQuestionId(id:number)
  { 
    this.questionService.setCurrQuestionId(id);
  }

  onOpenAnswerForm(question:Question) {
    // question.toggleAnswer = !question.toggleAnswer;
    // question.answers.push()
  }

  updateCurrQuestionsAnswers(answers:Answer[], question:Question) {
    console.log(answers);
    console.log(question);
    question.answers = answers;
  }
}