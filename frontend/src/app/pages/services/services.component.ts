import { Component, OnInit } from '@angular/core';
import { OfferedServiceApi, OfferedService } from '../../services/api/offered.service';

@Component({
  selector: 'app-services',
  standalone: true,
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.scss'],
  imports: [],
})
export class ServicesComponent implements OnInit {
  services: OfferedService[] = [];

  constructor(private api: OfferedServiceApi) {}

  ngOnInit() {
    this.api.getAll().subscribe(data => this.services = data);
  }
}
