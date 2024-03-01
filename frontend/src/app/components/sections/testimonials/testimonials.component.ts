import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-testimonials',
  templateUrl: './testimonials.component.html',
  styleUrls: ['./testimonials.component.scss']
})
export class TestimonialsComponent implements OnInit {
  @Input() themeType: string;

  constructor() { }

  ngOnInit(): void {
  }

}
