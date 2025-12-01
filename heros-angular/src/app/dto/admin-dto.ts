export class AdminDto {

  constructor(
    private _id: number | null,
    private _login: string,       
    private _password: string,         
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


  public toJson(): any {
    return {
      login: this.login,
      password: this.password,
      // Retrait de  degats, et  motivation
    };
  }
}
