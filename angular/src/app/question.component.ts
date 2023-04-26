import { Component, OnInit } from '@angular/core';
import { QuestionService } from './QuestionService';
import { Question } from './question';
import { Answer } from './answer';

@Component({
  selector: 'question',
  templateUrl: './question.component.html'
})

export class QuestionComponent implements OnInit {

  toggleAnswer: boolean;
  question_form: Question;
  answers1: Answer[];
  answers2: Answer[];
  questions: Question[];

  constructor(private questionService:QuestionService) {

    this.toggleAnswer=true;
    this.question_form=new Question("","","","","","",[],"","");
    

    this.answers1 = [
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi"),
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi")
    ];

    this.answers2 = [
      new Answer("i am bad at sqrts?", "test_image2.png", "4/4/2004 22:22", "accepted","ok", "hi"),
      new Answer("i am bad at sqrts", "test_image2.png", "4/4/2004 22:22", "accepted","ok", "hi")
    ];

    this.questions = [
      new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4",this.answers1, "ok", "hi"),
      new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4",this.answers2, "ok", "hi")
    ];

  }
  
  ngOnInit(): void {
    console.log('hello');
    this.questionService.getQuestions().subscribe((data: Question[]) => {
      console.log(data);
      this.questions = data;
    });
  }

  onSubmitQuestion() {
    this.questions.push(this.question_form);
    console.log(this.question_form);
  }

  onAnswer() {
    this.toggleAnswer=!this.toggleAnswer;
    
  }
}