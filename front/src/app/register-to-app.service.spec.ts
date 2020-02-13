import { TestBed, inject } from '@angular/core/testing';

import { RegisterToAppService } from './register-to-app.service';

describe('RegisterToAppService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegisterToAppService]
    });
  });

  it('should be created', inject([RegisterToAppService], (service: RegisterToAppService) => {
    expect(service).toBeTruthy();
  }));
});
