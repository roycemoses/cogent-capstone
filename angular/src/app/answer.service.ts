import { HttpClient, HttpHeaders } from '@angular/common/http'
import { BehaviorSubject, Observable, ObservedValueOf } from 'rxjs';
import { Injectable } from '@angular/core';
import { Question } from 'src/app/question';
import { LoginService } from './app-routing/login/login.service';
import { Answer } from './answer';

@Injectable({
    providedIn:'root'
})
export class AnswerService
{
    private baseUrl = 'http://localhost:8080/answer';
    
    constructor (private httpClient:HttpClient, private loginService:LoginService) {}
    
    addAnswerToQuestion(answer:Answer):Observable<Answer> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        
        console.log("successfully added an answer to question")
        return this.httpClient.post<Answer>(`${this.baseUrl}/addanswer`, answer, {'headers':headers});
    }

    // setQuestionIdOfAnAnswer(answer:Answer):Observable<Answer>
    // {
    //     const headers= new HttpHeaders()
    //         .set('Authorization', 'Bearer ' + this.loginService.token)
    //         .set('Access-Control-Allow-Origin', '*')
    //         .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
    //         .set('Access-Control-Allow-Headers','*');
        
    //     console.log("updated the question_id of an answer")
    //     return this.httpClient.put<Answer>(`${this.baseUrl}/updateanswer`, answer, {'headers':headers});
    // }

    getAllAnswersByQuestionId(question_id:number):Observable<Answer[]>
    {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        
        return this.httpClient.get<Answer[]>(`${this.baseUrl}/getanswerbyquestionid/`+question_id, {'headers':headers}); 
    }
}