import { Component, AfterViewInit, ElementRef, inject } from '@angular/core';
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
  private el = inject(ElementRef);

  ngAfterViewInit(): void {
    gsap.registerPlugin(ScrollTrigger);

    gsap.to('.site-name', {
      scrollTrigger: {
        trigger: 'body',
        start: 'top top',
        end: '+=300',
        scrub: true,
      },
      xPercent: -100,
      opacity: 0,
      ease: 'power2.out',
    });

    const links = this.el.nativeElement.querySelectorAll('.nav-links a');

    links.forEach((link: HTMLElement) => {
      const underline = link.querySelector('.underline') as HTMLElement;

      if (underline) {
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
      }
    });
  }
}
