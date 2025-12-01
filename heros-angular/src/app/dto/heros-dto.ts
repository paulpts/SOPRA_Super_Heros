export class HeroDto {

  constructor(
    private _id: number | null,
    private _alias: string,       // nom super-héros
    private _nom: string,         // nom civil
    private _prenom: string,      // prénom civil
    private _popularite: number,
    private _sante: number,
    private _experience: number
    //  j'ai retiré pour l'instant  motivation et dégâts côté front
  ) {}

  public get id(): number | null {
    return this._id;
  }
  public set id(value: number | null) {
    this._id = value;
  }

  public get alias(): string {
    return this._alias;
  }
  public set alias(value: string) {
    this._alias = value;
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

  public get experience(): number {
    return this._experience;
  }
  public set experience(value: number) {
    this._experience = value;
  }

 
  public toJson(): any {
    return {
      alias: this.alias,
      nom: this.nom,
      prenom: this.prenom,
      popularite: this.popularite,
      sante: this.sante,
      experience: this.experience
      // Retrait de  degats, et  motivation
    };
  }
}
