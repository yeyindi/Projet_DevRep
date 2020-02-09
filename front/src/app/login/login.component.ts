import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model:loginModelView = {
    email:"",
    password:""
  }

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  public sendForm(){
    //check user's inputs


    //send request
    let url = "localhost:8080/api/login";
    this.http.get(url).subscribe(
      res => {
        //some codes
        alert("it works");
      },
      err => {
        alert("An error has occured");
      }
    );
  }
}

export interface loginModelView{
  email:string;
  password:string;
}
