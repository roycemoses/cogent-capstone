import { Component, OnInit } from '@angular/core';
import { Answer } from './answer';

@Component({
  selector: 'answer',
  templateUrl: './answer.component.html'
})
export class AnswerComponent implements OnInit {

  answers: Answer[];
  constructor() {
    this.answers = [
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi"),
      new Answer("i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted","ok", "hi")
    ];
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
}