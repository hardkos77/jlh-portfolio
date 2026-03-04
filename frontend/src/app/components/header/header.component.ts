import {
  AfterViewInit,
  Component,
  ElementRef,
  Inject,
  PLATFORM_ID,
  ViewChild,
} from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { RouterModule } from '@angular/router';
import gsap from 'gsap';
import ScrollTrigger from 'gsap/ScrollTrigger';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  imports: [RouterModule],
})
export class HeaderComponent implements AfterViewInit {
  @ViewChild('headerRoot', { static: true })
  headerRoot!: ElementRef<HTMLElement>;

  constructor(@Inject(PLATFORM_ID) private platformId: Object) { }

  ngAfterViewInit(): void {
    if (!isPlatformBrowser(this.platformId)) return;

    gsap.registerPlugin(ScrollTrigger);

    gsap.to('.site-name', {
      scrollTrigger: {
        trigger: document.body,
        start: 'top top',
        end: '+=300',
        scrub: true,
      },
      xPercent: -100,
      opacity: 0,
      ease: 'power2.out',
    });

    const root = this.headerRoot?.nativeElement;
    if (!root) return;

    const links = root.querySelectorAll<HTMLAnchorElement>('.nav-links a');

    links.forEach((link) => {
      const underline = link.querySelector<HTMLElement>('.underline');
      if (!underline) return;

      gsap.set(underline, { scaleX: 0, transformOrigin: 'right' });

      link.addEventListener('mouseenter', () => {
        gsap.to(underline, {
          scaleX: 1,
          transformOrigin: 'left',
          duration: 0.4,
          ease: 'power2.out',
        });
      });

      link.addEventListener('mouseleave', () => {
        gsap.to(underline, {
          scaleX: 0,
          transformOrigin: 'right',
          duration: 0.4,
          ease: 'power2.in',
        });
      });
    });
  }
}