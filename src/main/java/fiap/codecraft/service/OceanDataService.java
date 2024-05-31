package fiap.codecraft.service;

import fiap.codecraft.DTO.request.OceanDataCreateDTORequest;
import fiap.codecraft.model.OceanData;
import fiap.codecraft.model.OceanObject;
import fiap.codecraft.repository.OceanDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OceanDataService {

    private OceanDataRepository oceanDataRepository;

    public OceanDataService(OceanDataRepository oceanDataRepository) {
        this.oceanDataRepository = oceanDataRepository;
    }

    public OceanData save(OceanDataCreateDTORequest oceanDataCreateDTORequest) {

        List<OceanObject> oceanObjects = oceanDataCreateDTORequest.oceanObjects()
                .stream()
                .map(e -> new OceanObject(null, e.objectType(), e.objectWeight(), null))
                .toList();

        OceanData oceanData = new OceanData(null, oceanDataCreateDTORequest.oceanType(),
                oceanDataCreateDTORequest.recordDate(),
                oceanDataCreateDTORequest.waterTemperature(),
                oceanDataCreateDTORequest.waterPollutionLevel(),
                oceanObjects
        );

        oceanData.getOceanObjects().forEach(e -> e.setOceanData(oceanData));

        return oceanDataRepository.save(oceanData);
    }

    public List<OceanData> getAllOceanData(){
        return oceanDataRepository.findAll();
    }

}
