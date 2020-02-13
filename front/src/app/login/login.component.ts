import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import { ReactiveFormsModule} from '@angular/form'
import{RegisterToAppService} from '../register-to-app.service';

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
    confirmed:false,
  };
  modelConf:ConfModelView={
    title:"",
    early_date:"",
    late_date:"",
    early_prices:"",
    late_prices:"",
    registraton_type:"",
  };
  reqs:registerModelView[];
  showForm:boolean = false;
  superAdmin:boolean = false;
  indexEarly = 0;
  indexLate = 0;
  eprice1:priceModel = {
    name:"",
    price:"",
  };
  eprice2: priceModel={
    name:"",
    price :"",
  };
  eprice3: priceModel={
    name :"",
    price :"",
  };
  lprice1: priceModel={
    name :"",
    price :"",
  };
  lprice2: priceModel={
    name :"",
    price :"",
  };
  lprice3: priceModel={
    name :"",
    price :"",
  };
  constructor(private http:HttpClient,private _sharedService: RegisterToAppService) {

    this._sharedService.changeEmitted$.subscribe(
      text => {
        if(text == "admin"){
          this.showForm = true;
          this.superAdmin = false;

        }
        else{
          this.showForm = false;
          this.superAdmin = true;
        }
      }
    )
   }

  ngOnInit() {
  }

  public sendForm(){
    //check user's inputs
    //send request
    let url = "http://localhost:8080/api/login";
    this.modelLogin["confirm"] = this.modelLogin["password"];
    this.http.post<string>(url,this.modelLogin).subscribe(
      res => {
        //some codes
        console.log(res);
        if(res == "Unkown" ){
          alert("wrong email or password");
        }
        else if(res == "Admin"){
          this.showForm = true;
          this._sharedService.emitloggin("Admin");
        }
        else if (res == "SuperAdmin"){
            this.showForm = false;
            this.superAdmin = true;
            this._sharedService.emitloggin("SuperAdmin");
            this.http.get<registerModelView[]>("http://localhost:8080/api/register").subscribe(
              res => {
                this.reqs = res;
                this.reqs= this.reqs.filter(req => req.confirmed != true);

              },
              err =>{
                console.log(err);
              }
            )
        }
        else{
          alert("Waiting validation for Super Administrator");
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  public deleteReq(r:registerModelView){
    this.http.delete("http://localhost:8080/api/register/"+r.id).subscribe(
      res => {
        alert("Successfull")
      },
      err => {
        alert(err);
      }
    );
    this.reqs= this.reqs.filter(req => req != r);
  }
  public accept(r:registerModelView){
    this.http.get<boolean>("http://localhost:8080/api/register/add/"+r.id).subscribe(
      res =>{
          if (res == true){
            this.reqs= this.reqs.filter(req => req != r);
            alert("Sucessfull");
          }
          else{
            alert("Can not accept, see the error in console ");
          }
      },
      err => {
        console.error(err);
      }
    );
  }
  public publishConf(){
    this.modelConf.early_prices = this.eprice1.name+": "+this.eprice1.price
     +","+this.eprice2.name+": "+this.eprice2.price
     +","+this.eprice3.name+": "+this.eprice3.price;
     this.modelConf.late_prices = ","+this.lprice1.name+": "+this.lprice1.price
     +","+this.lprice2.name+": "+this.lprice2.price
     +","+this.lprice3.name+": "+this.lprice3.price;
    let url = "http://localhost:8080/api/conf";
    console.log(this.modelConf);
    this.http.post<ConfModelView>(url,this.modelConf).subscribe(
      res => {
          alert("It is done");
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
  id:string;
  confirmed:boolean;
}

export interface ConfModelView{
  title:string;
  early_date:string;
  late_date:string;
  early_prices:string;
  late_prices:string;
  registraton_type:string;
}

export interface priceModel{
  name:string;
  price:string;
}
