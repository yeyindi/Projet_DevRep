import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import { Subject } from 'rxjs';
@Injectable()
export class RegisterToAppService {
  private emitChangeSource = new Subject<string>();
  changeEmitted$ = this.emitChangeSource.asObservable();
  emitloggin(change:string){
    this.emitChangeSource.next(change);
  }
  emitchangeStatus(change:string){
    this.emitChangeSource.next(change);
  }

  constructor() { }

}
