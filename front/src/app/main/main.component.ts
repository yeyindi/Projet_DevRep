import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private http:HttpClient) {
      //get conf
      let url = "localhost:8080/api/getConf";
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

  ngOnInit() {
  }

}
