import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { Router, RouterModule,Routes } from "@angular/router";
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

const appRoutes:Routes = [
  {
  path:"/login",
  component:LoginComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
    //RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
