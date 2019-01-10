export interface Destination {
  destinationId: number;
  destinationCode: string;
  destinationName: string;
  destinationAirport: string;
  destinationDescription: string;

  /*toString(): string {
    return this.destinationCode + ', ' + this.destinationName + ', ' + this.destinationAirport ;
  }*/
}
