export class AuthResponseDto {
    constructor(private _token: string, private _success: boolean, private _id: number) { }

    public get token(): string {
        return this._token;
    }

    public set token(value: string) {
        this._token = value;
    }

    public get success(): boolean {
        return this._success;
    }

    public set success(value: boolean) {
        this._success = value;
    }

   public get id(): number {
        return this._id;
    }           
    public set id(value: number) {
        this._id = value;
    }
    

}
