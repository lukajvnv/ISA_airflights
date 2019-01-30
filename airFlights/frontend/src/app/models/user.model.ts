export class User {
    ime: string;
    prezime: string;
    adresa: string;
    telefon: string;
    mail: string;
    brPasosa: string;

    pozvan: boolean;

    constructor(ime: string, prezime: string, adresa: string, mail: string,
      telefon: string) {
      this.ime = ime;
      this.prezime = prezime;
      this.adresa = adresa;
      this.mail = mail;
      this.telefon = telefon;
      // this.brPasosa = brPasosa;
      this.pozvan = false;
    }
}
