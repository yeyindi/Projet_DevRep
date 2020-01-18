import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { Router, RouterModule,Routes } from "@angular/router";
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { MainComponent } from './main/main.component';
import { RegisterComponent } from './register/register.component';

const appRoutes:Routes = [
  {
  path:'login',
  component:LoginComponent
  },
  {
  path:'inscription',
  component:InscriptionComponent
  },
  {
    path:'',
    component:MainComponent
  },
  {
    path:"register",
    component:RegisterComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    LoginComponent,
    MainComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
