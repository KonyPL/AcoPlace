// import { Component, Input, OnInit } from '@angular/core';
// import { MediaObserver, MediaChange } from '@angular/flex-layout';
// import { Subscription } from 'rxjs';
// @Component({
//   selector: 'app-box',
//   templateUrl: './box.component.html',
//   styleUrls: ['./box.component.css']
// })
// export class BoxComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }
//   @Input() deviceXs: boolean;
//   topVal = 0;
//   onScroll(e: { srcElement: { scrollTop: number; }; }) {
//     let scrollXs = this.deviceXs ? 55 : 73;
//     if (e.srcElement.scrollTop < scrollXs) {
//       this.topVal = e.srcElement.scrollTop;
//     } else {
//       this.topVal = scrollXs;
//     }
//   }
//   sideBarScroll() {
//     let e = this.deviceXs ? 160 : 130;
//     return e - this.topVal;
//   }

// }
