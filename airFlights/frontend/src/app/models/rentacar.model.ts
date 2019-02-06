import { Rentabranch } from './rentabranch.model';
import { Car } from './car.model';
export interface Rentacar {
  
    rentacarId: number;
	name: string;
	adress: string;
	promoDescription: string;
	avgRating: number;
	ratingNumber: number;
	income: number;
    cars: Car[];
    branches: Rentabranch[];
}
