import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ExampleInterceptor implements HttpInterceptor {

  constructor() {}

    intercept(httpRequest: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const reqCopy = httpRequest.clone()
        reqCopy.headers.set("Access-Control-Allow-Origin", "*")
        
        return next.handle(reqCopy);
    }
}
