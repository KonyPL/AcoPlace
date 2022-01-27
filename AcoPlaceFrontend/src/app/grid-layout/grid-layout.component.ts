// import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
// import { Component, OnInit } from '@angular/core';
// import { map } from 'rxjs/operators';

// @Component({
//   selector: 'app-grid-layout',
//   templateUrl: './grid-layout.component.html',
//   styleUrls: ['./grid-layout.component.css']
// })
// export class GridLayoutComponent implements OnInit {

//   constructor() { private breakpointObserver: BreakpointObserver }

//   ngOnInit(): void {
//   }

// }

// cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(map(({ matches }) => {
//   if (matches) {
//     return [
//       { title: 'Card 1', cols: 1, rows: 1 },
//       { title: 'Card 2', cols: 1, rows: 1 },
//       { title: 'Card 3', cols: 1, rows: 1 },
//       { title: 'Card 4', cols: 1, rows: 1 },
//     ];
//   }
//   return [
//     { title: 'Card 1', cols: 2, rows: 1 },
//     { title: 'Card 2', cols: 1, rows: 1 },
//     { title: 'Card 3', cols: 1, rows: 2 },
//     { title: 'Card 4', cols: 1, rows: 1 },

//   ];
// })
// );
