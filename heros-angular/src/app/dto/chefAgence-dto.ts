
export class ChefAgenceDto  {

  constructor(
    private _id: number | null,
    private _login: string,       // login du compte 
    private _password: string,         // password 
    private _nom: string,
    private _prenom: string,
    private _agenceId?: number,
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

  public get agenceId(): number | undefined {
    return this._agenceId;
  }
  public set agenceId(value: number | undefined) {
    this._agenceId = value;
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
      agenceId: this.agenceId,
      // Retrait de  degats, et  motivation
    };
  }
}
