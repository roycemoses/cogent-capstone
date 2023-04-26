import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
// import { UserComponent } from './user.component';
import { LoginComponent } from './login.component';
import { ExampleInterceptor } from './example.interceptor';

@NgModule({
  declarations: [
    AppComponent, LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginComponent,
{
    provide: HTTP_INTERCEPTORS, useClass: ExampleInterceptor, multi: true   
}],
  bootstrap: [AppComponent]
})
export class AppModule { }
