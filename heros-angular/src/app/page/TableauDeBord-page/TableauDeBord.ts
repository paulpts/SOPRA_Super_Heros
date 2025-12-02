// import { CommonModule } from '@angular/common';
// import { Component, OnInit } from '@angular/core';
// import {
//   FormBuilder,
//   FormControl,
//   FormGroup,
//   ReactiveFormsModule,
//   Validators,
// } from '@angular/forms';
// import { ActivatedRoute } from '@angular/router';
// import { Observable } from 'rxjs';

// import { HerosDto } from '../../dto/heros-dto';
// import { AgenceDto } from '../../dto/agence-dto';
// import { HerosService } from '../../service/heros-service';
// import { AgenceService } from '../../service/agence-service';

// type ChefFilter = 'AGENCE' | 'ALPHA' | 'BETA' | 'OMEGA';

// @Component({
//   standalone: true,
//   imports: [CommonModule, ReactiveFormsModule],
//   templateUrl: './TableauDeBord.html',
// })
// export class TableauDeBordPage implements OnInit {


//   protected isAdmin: boolean = false;

 
//   protected heros$!: Observable<HerosDto[]>;

  
//   protected agences$!: Observable<AgenceDto[]>;

  
//   protected herosChef$!: Observable<HerosDto[]>;

  
//   protected chefFilter: ChefFilter = 'AGENCE';

 
//   protected showForm: boolean = false;
//   protected herosForm!: FormGroup;

//   protected nomCtrl!: FormControl;
//   protected prenomCtrl!: FormControl;
//   protected aliasCtrl!: FormControl;
//   protected populariteCtrl!: FormControl;
//   protected santeCtrl!: FormControl;
//   protected salaireCtrl!: FormControl;
//   protected coutCreationCtrl!: FormControl;
//   protected experienceCtrl!: FormControl;
//   protected degatsCtrl!: FormControl;
//   protected motivationCtrl!: FormControl;
//   protected agenceCtrl!: FormControl;

//   protected editingHeros: HerosDto | null = null;

  
//   private readonly CURRENT_AGENCE_ID_FOR_CHEF = 1;

//   constructor(
//     private route: ActivatedRoute,
//     private herosService: HerosService,
//     private agenceService: AgenceService,
//     private formBuilder: FormBuilder,
//   ) { }

//   ngOnInit(): void {
    
//     const role = this.route.snapshot.data['role'] as string | undefined;
//     this.isAdmin = role === 'ADMIN';

//     // --- Déclaration des contrôles du formulaire ---
//     this.nomCtrl = this.formBuilder.control('', Validators.required);
//     this.prenomCtrl = this.formBuilder.control('', Validators.required);
//     this.aliasCtrl = this.formBuilder.control('', Validators.required);

//     this.populariteCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);
//     this.santeCtrl = this.formBuilder.control(100, [Validators.required, Validators.min(0)]);
//     this.salaireCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);
//     this.coutCreationCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);
//     this.experienceCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);
//     this.degatsCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);
//     this.motivationCtrl = this.formBuilder.control(0, [Validators.required, Validators.min(0)]);

//     this.agenceCtrl = this.formBuilder.control(
//       '',
//       this.isAdmin ? Validators.required : [],
//     );

//     this.herosForm = this.formBuilder.group({
//       nom: this.nomCtrl,
//       prenom: this.prenomCtrl,
//       alias: this.aliasCtrl,
//       popularite: this.populariteCtrl,
//       sante: this.santeCtrl,
//       salaire: this.salaireCtrl,
//       coutCreation: this.coutCreationCtrl,
//       experience: this.experienceCtrl,
//       degats: this.degatsCtrl,
//       motivation: this.motivationCtrl,
//       agence: this.agenceCtrl,
//     });

//     // --- Chargement des données selon le rôle ---
//     if (this.isAdmin) {
      
//       this.heros$ = this.herosService.findAll();
//       this.agences$ = this.agenceService.findAll();
//     } else {
      
//       this.changerFiltreChef('AGENCE');
//     }
//   }

//   // ---------------------- ADMIN ----------------------

//   protected trackHeros(index: number, heros: HerosDto) {
//     return heros.id;
//   }

//   protected trackAgence(index: number, agence: AgenceDto) {
//     return agence.id;
//   }

//   // ---------------------- CHEF D'AGENCE ----------------------

  
//   public changerFiltreChef(filter: ChefFilter): void {
//     this.chefFilter = filter;

//     switch (filter) {
//       case 'AGENCE':
    
//         this.herosChef$ = this.herosService.findByAgence(this.CURRENT_AGENCE_ID_FOR_CHEF);
//         break;
//       case 'ALPHA':
        
//         this.herosChef$ = this.herosService.findAllAlpha();
//         break;
//       case 'BETA':
        
//         this.herosChef$ = this.herosService.findAllBeta();
//         break;
//       case 'OMEGA':
      
//         this.herosChef$ = this.herosService.findAllOmega();
//         break;
//     }
//   }

//   // ---------------------- FORMULAIRE COMMUN ----------------------

//   /** Affiche le formulaire en mode création */
//   public afficherFormulaireCreation(): void {
//     this.editingHeros = null;
//     this.herosForm.reset();
//     this.showForm = true;

//     if (!this.isAdmin) {
      
//       this.agenceCtrl.setValue(this.CURRENT_AGENCE_ID_FOR_CHEF.toString());
//     }
//   }

 
//   public creerOuModifier(): void {
//     if (this.herosForm.invalid) {
//       return;
//     }

//     const agenceId = this.isAdmin
//       ? this.agenceCtrl.value
//       : this.CURRENT_AGENCE_ID_FOR_CHEF.toString();

//     const dto = new HerosDto(
//       this.editingHeros ? this.editingHeros.id : '',
//       this.nomCtrl.value,
//       this.prenomCtrl.value,
//       this.aliasCtrl.value,
//       this.isAdmin ? this.populariteCtrl.value : 0,
//       this.isAdmin ? this.santeCtrl.value : 0,
//       this.isAdmin ? this.salaireCtrl.value : 0,
//       this.isAdmin ? this.coutCreationCtrl.value : 0,
//       this.isAdmin ? this.experienceCtrl.value : 0,
//       this.isAdmin ? this.degatsCtrl.value : 0,
//       this.isAdmin ? this.motivationCtrl.value : 0,
//       agenceId,
//     );

//     this.herosService.save(dto);

//     this.showForm = false;
//     this.editingHeros = null;
//     this.herosForm.reset();

//     if (this.isAdmin) {
//       this.herosService.refresh(); 
//     } else {
      
//       this.changerFiltreChef(this.chefFilter);
//     }
//   }

//   public annulerEditer(): void {
//     this.showForm = false;
//     this.editingHeros = null;
//     this.herosForm.reset();
//   }
// }
