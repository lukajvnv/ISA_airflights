import { TestBed } from '@angular/core/testing';

import { RentabranchService } from './rentabranch.service';

describe('RentabranchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RentabranchService = TestBed.get(RentabranchService);
    expect(service).toBeTruthy();
  });
});
