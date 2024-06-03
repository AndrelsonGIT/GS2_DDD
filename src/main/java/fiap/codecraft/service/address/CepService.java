package fiap.codecraft.service.address;

import fiap.codecraft.exception.AddressNotFoundException;

public interface CepService {
    AddressResponse findAddress(String cep) throws AddressNotFoundException;
}
