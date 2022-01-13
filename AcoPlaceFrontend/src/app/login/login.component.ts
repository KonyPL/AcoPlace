import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { throwError } from 'rxjs';
import { AuthService } from './auth.service';
import { LoginDto } from './login-request.payload';
import { UserNameDto } from './user-name-dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loginRequestPayload: LoginDto;
  registerSuccessMessage: string;
  isError: boolean;

  constructor(private authService: AuthService, private activatedRoute: ActivatedRoute,
    private router: Router) {
    this.loginRequestPayload = {
      usernameOrEmail: '',
      password: ''
    };
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });

    
  }

  login() {
    this.loginRequestPayload.usernameOrEmail = this.loginForm.get('username')!.value;
    this.loginRequestPayload.password = this.loginForm.get('password')!.value;

    this.authService.login(this.loginRequestPayload).subscribe((data: any) => {
      this.isError = false;
      this.router.navigateByUrl('');
    }, (error: any) => {
      this.isError = true;
      throwError(error);
    });
  }

  isLoggedIn(){
    this.authService.isloggedIn().subscribe((data: any) => {
      console.log("IS LOGGED IN"+data);
    });
  }

  getUserName(){
    this.authService.getUserName().subscribe((data: UserNameDto) => {
      console.log("USER NAME"+data.name);
    });
  }
}
