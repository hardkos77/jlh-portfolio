import { Component, Input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { PageTitleComponent } from '../../components/page-title/page-title.component';

@Component({
  selector: 'app-contact',
  imports: [ReactiveFormsModule, PageTitleComponent],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss'
})
export class ContactComponent {

}
