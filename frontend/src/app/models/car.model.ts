export class Car {
    
    carId: number;
	reserved: boolean;
	pickupDate: string;
	dropofDate: string;
	pickupLocation: string;
	dropofLocation: string;
	carName: string;
	carBrand: string;
	carModel: string;
    carYear: number;
	numberOfSeats: number;
    price: number;
    tip: string;
  
    constructor() { 
    }

    initComplexData(pickDate: Date, dropDate: Date) {
        let trueMonth = ('0' + pickDate['month']).slice(-2);
        let trueDay = ('0' + pickDate['day']).slice(-2);
        this.pickupDate = pickDate['year'] + '-' + trueMonth + '-' + trueDay;
    
        trueMonth = ('0' + dropDate['month']).slice(-2);
        trueDay = ('0' + dropDate['day']).slice(-2);
        this.dropofDate = dropDate['year'] + '-' + trueMonth + '-' + trueDay;
      }
  } 