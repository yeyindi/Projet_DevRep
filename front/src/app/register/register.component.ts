import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router'

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

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit() {
  }
  public sendForm(){
    //check user's inputs


    //send request
    let url = "http://localhost:8080/api/register";
    this.http.post(url,this.model).subscribe(
      res => {
        if(res != true){
          alert("Email already exist, enter a new email")
        }
        else{
          alert("Sucessfull, waiting Super administrator validate your inscription, check your email");
            this.router.navigate(["login"]);
        }
    },
      err => {
        alert("error, can not create a new account, try later");
      }
    );
  }
}

export interface registerModelView{
  email:string;
  password:string;
  confirm:string;
}
