export class User {
    id: number;

    username: string;
    firstName: string;
    lastName: string;
    city: string;
    phone_number: number;
    email: string;

    // brPasosa: string;

    pozvan: boolean;

    constructor(ime: string, prezime: string, adresa: string, mail: string,
      telefon: number, username: string) {
      this.firstName = ime;
      this.lastName = prezime;
      this.city = adresa;
      this.email = mail;
      this.phone_number = telefon;
      this.username = username;

      this.city = 'Stevana supljikca';

      this.pozvan = false;
    }
}
