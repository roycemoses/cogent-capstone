import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = "http://localhost:8080/q/all";

  constructor(private http: HttpClient) { }

  getQuestions(): Observable<Question[]>{
    // const headers = 
    return this.http.get<Question[]>(`${this.baseUrl}`);
  }
}