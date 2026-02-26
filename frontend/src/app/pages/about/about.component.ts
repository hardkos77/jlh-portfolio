import { Component, OnInit } from '@angular/core';
import { Skill, SkillApi } from '../../services/api/skills.service';

@Component({
  selector: 'app-about',
  standalone: true,
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss'],
  imports: [],
})
export class AboutComponent implements OnInit {
  skills: Skill[] = [];

  constructor(private skillsApi: SkillApi) {}

  ngOnInit() {
    this.skillsApi.getAll().subscribe(data => this.skills = data);
  }
}
