import { Component, OnInit } from '@angular/core';
import { Answer } from './answer';

@Component({
  selector: 'answer',
  templateUrl: './answer.component.html'
})
export class AnswerComponent implements OnInit {
  //answer_form=new Answer("","","","","","");
  //answers: Answer[];
  constructor() {
   
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