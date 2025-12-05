export class MissionDto {

  constructor(
    private _id: number | null,  // id peut etre null quand la mission n'a pas encore été crée en BDD 
    private _difficulte: number,
    private _description: string,
    private _niveauDanger: number,
    private _ville: string,
    private _statut: string,
    private _creditMission: number,
    private _agenceId: number | null,
    private _herosId: number | null,
  ) {}

  

  public get id(): number | null {
    return this._id;
  }
  public set id(value: number | null) {
    this._id = value;
  }

  public get difficulte(): number {
    return this._difficulte;
  }
  public set difficulte(value: number) {
    this._difficulte = value;
  }

  public get description(): string {
    return this._description;
  }
  public set description(value: string) {
    this._description = value;
  }

  public get niveauDanger(): number {
    return this._niveauDanger;
  }
  public set niveauDanger(value: number) {
    this._niveauDanger = value;
  }

  public get ville(): string {
    return this._ville;
  }
  public set ville(value: string) {
    this._ville = value;
  }

  public get statut(): string {
    return this._statut;
  }
  public set statut(value: string) {
    this._statut = value;
  }

  public get creditMission(): number {
    return this._creditMission;
  }
  public set creditMission(value: number) {
    this._creditMission = value;
  }

  public get agenceId(): number | null {
    return this._agenceId;
  }
  public set agenceId(value: number | null) {
    this._agenceId = value;
  }

  public get herosId(): number | null {
    return this._herosId;
  }
  public set herosId(value: number | null) {
    this._herosId = value;
  }

  public toJson(): any {
    return {
      difficulte: this.difficulte,
      description: this.description,
      niveauDanger: this.niveauDanger,
      ville: this.ville,
      statut: this.statut,
      creditMission: this.creditMission,
      agenceId: this.agenceId,
      herosId:   this.herosId,
    };
  }
}
