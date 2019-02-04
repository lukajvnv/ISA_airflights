export class User {
    id: number;

    username: string;
    firstName: string;
    lastName: string;
    address: string;
    phone_number: string;
    email: string;

    // brPasosa: string;

    pozvan: boolean;

    constructor(ime: string, prezime: string, adresa: string, mail: string,
      telefon: string) {
      this.firstName = ime;
      this.lastName = prezime;
      this.address = adresa;
      this.email = mail;
      this.phone_number = telefon;
      // this.brPasosa = brPasosa;

      this.address = 'Stevana supljikca';

      this.pozvan = false;
    }
}
