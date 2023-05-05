import { HttpClient, HttpHeaders } from '@angular/common/http'
import { BehaviorSubject, Observable, ObservedValueOf } from 'rxjs';
import { Injectable } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Question } from 'src/app/question';
import * as myGlobals from '../../globals';

@Injectable({
    providedIn:'root'
})
export class QuestionDetailsService
{
    question!:Question;

    private baseUrl = 'http://' + myGlobals.ip + ':8080/question';
    
    constructor (private httpClient:HttpClient, private loginService:LoginService) {}
    
    getQuestionById(id:number):Observable<Question> {
        const headers= new HttpHeaders()
            .set('Authorization', 'Bearer ' + this.loginService.token)
            .set('Access-Control-Allow-Origin', '*')
            .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
            .set('Access-Control-Allow-Headers','*');
        this.httpClient.get<Question>(`${this.baseUrl}/getquestionbyid/`+id, {'headers':headers}).subscribe((data)=>{
            this.question = data;
        })
        return this.httpClient.get<Question>(`${this.baseUrl}/getquestionbyid/`+id, {'headers':headers});
    }
}