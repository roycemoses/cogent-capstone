import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { QuestionComponent } from './question.component';
import { AppComponent } from './app.component';
import { UserComponent } from './user.component';
import { LoginComponent } from './login.component';

@NgModule({
  declarations: [
    AppComponent, UserComponent, LoginComponent, QuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
