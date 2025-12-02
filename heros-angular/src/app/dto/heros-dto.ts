export class HerosDto {
  constructor(
    private _id: string,
    private _nom: string,
    private _prenom: string,
    private _alias: string,
    private _popularite: number,
    private _sante: number,
    private _salaire: number,
    private _coutCreation: number,
    private _experience: number,
    private _degats: number,
    private _motivation: number,
    private _agenceId?: string,
   // private _missionIds: number[] = [], (tableau contenant plusieurs id de missions)
   // private _pouvoirs: string[] = [],
  ) { }

  public get id(): string {
    return this._id;
  }
  public set id(value: string) {
    this._id = value;
  }

  public get nom(): string {
    return this._nom;
  }
  public set nom(value: string) {
    this._nom = value;
  }

  public get prenom(): string {
    return this._prenom;
  }
  public set prenom(value: string) {
    this._prenom = value;
  }

  public get alias(): string {
    return this._alias;
  }
  public set alias(value: string) {
    this._alias = value;
  }

  public get popularite(): number {
    return this._popularite;
  }
  public set popularite(value: number) {
    this._popularite = value;
  }

  public get sante(): number {
    return this._sante;
  }
  public set sante(value: number) {
    this._sante = value;
  }

  public get salaire(): number {
    return this._salaire;
  }
  public set salaire(value: number) {
    this._salaire = value;
  }

  public get coutCreation(): number {
    return this._coutCreation;
  }
  public set coutCreation(value: number) {
    this._coutCreation = value;
  }

  public get experience(): number {
    return this._experience;
  }
  public set experience(value: number) {
    this._experience = value;
  }

  public get degats(): number {
    return this._degats;
  }
  public set degats(value: number) {
    this._degats = value;
  }

  public get motivation(): number {
    return this._motivation;
  }
  public set motivation(value: number) {
    this._motivation = value;
  }

  public get agenceId(): string | undefined {
    return this._agenceId;
  }
  public set agenceId(value: string | undefined) {
    this._agenceId = value;
  }

  /* public get pouvoirs(): string[] {
    return this._pouvoirs;
  }
  public set pouvoirs(value: string[]) {
    this._pouvoirs = value;
  }

  public get missionsIds(): number[] {
    return this._missionsIds;
  }
  public set missionsIds(value: number[]) {
    this._missionsIds = value;
  }*/

  public toJson(): any {
    
    return {
      nom: this.nom,
      prenom: this.prenom,
      alias: this.alias,
      popularite: this.popularite,
      sante: this.sante,
      salaire: this.salaire,
      coutCreation: this.coutCreation,
      experience: this.experience,
      degats: this.degats,
      motivation: this.motivation,
      agence: this.agenceId ? { id: Number(this.agenceId) } : null// Le back attend un objet "agence" (avec une propriété id)
    };                                                            // null : valeur envoyee quand aucune agence n'est sélectionnée
  }
}