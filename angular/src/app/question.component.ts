import { Component, OnInit } from '@angular/core';
import { QuestionService } from './QuestionService';
import { Question } from './question';
import { Answer } from './answer';

@Component({
  selector: 'question',
  templateUrl: './question.component.html'
})

export class QuestionComponent implements OnInit {
  question_form: Question;
  answers1: Answer[];
  answers2: Answer[];
  questions: Question[];

  constructor(private questionService:QuestionService) {

    this.question_form=new Question("","","","","","",[],"","", false);    

    this.answers1 = [
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi"),
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi")
    ];

    this.answers2 = [
      new Answer("i am bad at sqrts?", "test_image2.png", "4/4/2004 22:22", "accepted","ok", "hi"),
      new Answer("i am bad at sqrts", "test_image2.png", "4/4/2004 22:22", "no","ok", "hi")
    ];

    this.questions = [
      new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4",[], "ok", "hi", false),
      new Question("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4",this.answers2, "ok", "hi", false)
    ];

  }
  
  ngOnInit(): void {
    console.log('hello');
    this.questionService.getQuestions().subscribe((data: Question[]) => {
      console.log(data);
      this.questions = data;
    });
  }

  onSubmitQuestion(questionform:any) {
    this.questions.push(questionform);
    console.log(questionform.value);
  }

  onOpenAnswerForm(question:Question) {
    question.toggleAnswer = !question.toggleAnswer;
    // question.answers.push()
  }

  updateCurrQuestionsAnswers(answers:Answer[], question:Question) {
    console.log(answers);
    console.log(question);
    question.answers = answers;
  }
}