import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Answer } from './answer';

@Component({
  selector: 'answer',
  templateUrl: './answer.component.html'
})
export class AnswerComponent implements OnInit {
  answer_form=new Answer("","","","","","");
  answers:Answer[];
  constructor() {
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

  @Output()
  answerEventEmitter = new EventEmitter();
  onSubmitAnswer() { 
      this.answers.push(this.answer_form);
      this.answerEventEmitter.emit(this.answers); // send it to parent
  }
}