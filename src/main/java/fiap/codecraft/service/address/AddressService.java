package fiap.codecraft.service.address;

import fiap.codecraft.model.UserAddressEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private CepService cepService;

    public AddressService(CepService cepService) {
        this.cepService = cepService;
    }

    public UserAddressEntity getAddress(String cep, int houseNumber) {
        AddressResponse addressResponse = cepService.findAddress(cep);

        return new UserAddressEntity(null,
                cep,
                houseNumber,
                addressResponse.getNeighborhood(),
                addressResponse.getState(),
                addressResponse.getCity(),
                addressResponse.getStreet());
    }
}
