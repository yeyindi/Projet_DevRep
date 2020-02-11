import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {

  constructor(private http:HttpClient,private route:ActivatedRoute) { }

  ngOnInit() {
  }
  pay(){
    let url = "http://localhost:8080/api/bank"
    let id = this.route.snapshot.params["user"];

    this.http.get("http://localhost:8080/api/users/"+id).subscribe(
      res => {
        console.log(res);
          this.http.post(url, res).subscribe(
            res => {
              console.log(res);
            },
            err => {
              console.log(err);
            }
          );
      },
      err =>{
          console.log(err);
      }
    );
  }
}
