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
    early_prices:["","",""],
    late_prices:["","",""]


  };
  isLoggedIn = true;
  indexEarly = 0;
  indexLate = 0;
  eprice1:[string,string];
  eprice2:[string,string];
  eprice3:[string,string];
  lprice1:[string,string];
  lprice2:[string,string];
  lprice3:[string,string];
  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  public sendForm(){
    //check user's inputs
    //send request
    let url = "http://localhost:8080/api/login";
    this.modelLogin["confirm"] = this.modelLogin["password"];
    this.http.post<boolean>(url,this.modelLogin).subscribe(
      res => {
        //some codes
        console.log(res);
        if(res == false ){
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
    console.log(this.eprice1[1])
    this.modelConf.early_prices[0] += this.eprice1[1]//+": "+this.eprice1[2];
    this.modelConf.early_prices[1] += this.eprice2[1]//+": "+this.eprice2[2];
    this.modelConf.early_prices[2] += this.eprice3[1]//+": "+this.eprice3[2];
    this.modelConf.late_prices[0] += this.lprice1[1]//+": "+this.lprice1[2];
    this.modelConf.late_prices[1] += this.lprice2[1]//+": "+this.lprice2[2];
    this.modelConf.late_prices[2] += this.lprice3[1]//+": "+this.lprice3[2];
    console.log(this.modelConf);
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
  early_prices:string[];
  late_prices:string[];
}
