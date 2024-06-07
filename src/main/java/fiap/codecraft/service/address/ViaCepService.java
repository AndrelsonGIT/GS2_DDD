package fiap.codecraft.service.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fiap.codecraft.exception.APIRequestException;
import fiap.codecraft.exception.AddressNotFoundException;
import fiap.codecraft.service.APIRequestCaller;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ViaCepService implements CepService {

    private APIRequestCaller apiCaller;

    public ViaCepService(APIRequestCaller apiCaller) {
        this.apiCaller = apiCaller;
    }

    @Override
    public AddressResponse findAddress(String cep) throws AddressNotFoundException {

        String jsonResponse;
        try {
            jsonResponse = apiCaller.get("https://viacep.com.br/ws/" + cep + "/json/");
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Erro de IO Exception");
            throw new APIRequestException("Could not get address from Viacep API", e);
        }

        AddressResponse addressResponse;
        try {
            addressResponse = new ObjectMapper().readValue(jsonResponse, AddressResponse.class);

            if(addressResponse.getCity().isBlank()){
                throw new AddressNotFoundException("Address not found");
            }

            return addressResponse;
        }
        catch (JsonProcessingException e) {
            System.out.println("Erro ao processar JSON");
            throw new RuntimeException("Erro ao converter JSON", e);
        }
    }
}
