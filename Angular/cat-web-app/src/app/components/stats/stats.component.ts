import { Component, OnInit } from '@angular/core';
import {EventDrivenService} from "../../services/Event.driven.service";
import {ActionEvent} from "../../state/product.state";

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
  public counter: number =0;

  constructor(private eventDrivenService:EventDrivenService) { }

  ngOnInit(): void {
    this.eventDrivenService.sourceEventSubjectObservable.subscribe((ationEvent:ActionEvent)=>{
      ++this.counter;
    })
  }

}
