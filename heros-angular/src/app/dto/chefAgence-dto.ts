
export class ChefAgenceDto  {

  constructor(
    private _id: number | null,
    private _login: string,       // login du compte 
    private _password: string,         // password 
    private _nom: string,
    private _prenom: string,
    private _agenceID?: number,
) {}

  public get id(): number | null {
    return this._id;
  }
  public set id(value: number | null) {
    this._id = value;
  }

  public get login(): string {
    return this._login;
  }
  public set login(value: string) {
    this._login = value;
  }

  public get password(): string {
    return this._password;
  }
  public set password(value: string) {
    this._password = value;
  }

  public get agenceID(): number | undefined {
    return this._agenceID;
  }
  public set agenceID(value: number | undefined) {
    this._agenceID = value;
  }

  public get nom(): string {
    return this._nom;
  }

  public get prenom(): string {
    return this._prenom;
  }

  public toJson(): any {
    return {
      login: this.login,
      password: this.password,
      nom: this.nom,
      prenom: this.prenom,
      agenceID: this.agenceID,
      // Retrait de  degats, et  motivation
    };
  }
}
