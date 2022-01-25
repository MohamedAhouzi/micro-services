import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {ActionEvent, ProductCommandActions, ProductQueryActions} from '../state/product.state';
@Injectable({providedIn:"root"})
export class EventDrivenService {
   sourceEventSubject:Subject<ActionEvent>=new Subject<ActionEvent>();
  sourceEventSubjectObservable=this.sourceEventSubject.asObservable();

  //private commandEventSource=new Subject<ActionEvent>();
  //commandEventSourceObservable=this.commandEventSource.asObservable();

  public publishEvent(event :ActionEvent){
    this.sourceEventSubject.next(event);
  }
 /* public publishCommandAction(action :ActionEvent){
    this.sourceEventSubject.next(action);
  }*/
}
