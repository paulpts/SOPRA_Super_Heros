export class AgenceDto {
  constructor(
    private _id: string,
    private _budget: number,
    private _popularite: number,
  ) { }

  public get id(): string {
    return this._id;
  }
  public set id(value: string) {
    this._id = value;
  }

  public get budget(): number {
    return this._budget;
  }
  public set budget(value: number) {
    this._budget = value;
  }

  public get popularite(): number {
    return this._popularite;
  }
  public set popularite(value: number) {
    this._popularite = value;
  }

  
  public toJson(): any {
    return {
      budget: this.budget,
      popularite: this.popularite,
    };
  }
}