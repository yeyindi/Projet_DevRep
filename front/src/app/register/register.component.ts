import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  model:registerModelView={
    email:"",
    password:"",
    confirm:""
  }

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }
  public sendForm(){
    //check user's inputs


    //send request
    let url = "localhost:8080/api/register";
    this.http.get(url).subscribe(
      res => {
        //some codes
        alert("it works");
        let i = 1;
      },
      err => {
        alert("An error has occured");
      }
    );
  }
}

export interface registerModelView{
  email:string;
  password:string;
  confirm:string;
}
