package fiap.codecraft.service;

import fiap.codecraft.DTO.request.OceanDataCreateDTORequest;
import fiap.codecraft.model.OceanDataEntity;
import fiap.codecraft.model.OceanObjectEntity;
import fiap.codecraft.repository.OceanDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OceanDataService {

    private OceanDataRepository oceanDataRepository;

    public OceanDataService(OceanDataRepository oceanDataRepository) {
        this.oceanDataRepository = oceanDataRepository;
    }

    public OceanDataEntity save(OceanDataCreateDTORequest oceanDataCreateDTORequest) {

        List<OceanObjectEntity> oceanObjectEntities = oceanDataCreateDTORequest.oceanObjects()
                .stream()
                .map(e -> new OceanObjectEntity(null, e.objectType(), e.objectWeight(), null))
                .toList();

        OceanDataEntity oceanDataEntity = new OceanDataEntity(null, oceanDataCreateDTORequest.oceanType(),
                oceanDataCreateDTORequest.recordDate(),
                oceanDataCreateDTORequest.waterTemperature(),
                oceanDataCreateDTORequest.waterPollutionLevel(),
                oceanObjectEntities
        );

        oceanDataEntity.getOceanObjects().forEach(e -> e.setOceanData(oceanDataEntity));

        return oceanDataRepository.save(oceanDataEntity);
    }

    public List<OceanDataEntity> getAllOceanData(){
        return oceanDataRepository.findAll();
    }

}
