import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Pour naviguer vers une autre page
import { FormBuilder, FormControl ,FormGroup, Validators, ReactiveFormsModule} from '@angular/forms';
import { AuthRequestDto } from '../../dto/auth-request-dto';
import { AuthService } from '../../service/auth-service';
import { OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule], 
  templateUrl: './connexion-page.html',
  styleUrl: './connexion-page.css'
})
export class ConnexionPage implements OnInit {
  protected loginError: boolean = false;
  protected userForm!: FormGroup;
  protected usernameCtrl!: FormControl;
  protected passwordCtrl!: FormControl;
  protected idUtilisateur!: number;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control('', Validators.required);
    this.passwordCtrl = this.formBuilder.control('', [ Validators.required, Validators.minLength(6) ]);

    this.userForm = this.formBuilder.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl
    });
  }

  public async connecter() {
    try {
      await this.authService.auth(new AuthRequestDto(this.usernameCtrl.value, this.passwordCtrl.value));
      this.idUtilisateur = this.authService.id;
      this.router.navigate([ `/${this.idUtilisateur}` ]);
    }

    // Si la connexion n'a pas pu se faire, affichage de l'erreur sur le template
    catch {
      this.loginError = true;
    }
  }
}
