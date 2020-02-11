import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  modelLogin:registerModelView = {
    email:"",
    password:"",
    confirm:""
  };
  modelConf:ConfModelView={
    title:"",
    early:"",
    late:"",
    earlyPrices:Array<[string,number]>(),
    latePrices:Array<[string,number]>(),

  };
  isLoggedIn = true;
  indexEarly = 0;
  indexLate = 0;
  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  public sendForm(){
    //check user's inputs


    //send request
    let url = "http://localhost:8080/api/login";
    this.modelLogin["confirm"] = this.modelLogin["password"];
    this.http.post(url,this.modelLogin).subscribe(
      res => {
        //some codes
        console.log(res);
        if(res == null ){
          alert("wrong email or password");
        }
        else{
          this.isLoggedIn = true;
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  public publishConf(){
    let url = "http://localhost:8080/api/conf"
    this.http.post(url,this.modelConf).subscribe(
      res => {
          alert("it work ");
          console.log(res);
      },
      err => {
        alert("error");
        console.log(err);
      }
    )
  }
}

export interface loginModelView{
  email:string;
  password:string;
}

export interface registerModelView{
  email:string;
  password:string;
  confirm:string;
}

export interface ConfModelView{
  title:string;
  early:string;
  late:string;
  earlyPrices:Array<[string,number]>;
  latePrices:Array<[string,number]>;
}
