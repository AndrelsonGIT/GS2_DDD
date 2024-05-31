package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.OceanDataCreateDTORequest;
import fiap.codecraft.DTO.response.OceanDataDTOResponse;
import fiap.codecraft.model.OceanDataEntity;
import fiap.codecraft.service.OceanDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("oceanData")
public class OceanDataController {

    OceanDataService oceanDataService;

    public OceanDataController(OceanDataService oceanDataService) {
        this.oceanDataService = oceanDataService;
    }

    @PostMapping
    public ResponseEntity<OceanDataDTOResponse> createOceanData(@RequestBody OceanDataCreateDTORequest request) {
        OceanDataEntity oceanDataEntity = oceanDataService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OceanDataDTOResponse(oceanDataEntity));
    }

    @GetMapping
    public ResponseEntity<List<OceanDataDTOResponse>> getOceanData(){
        List<OceanDataEntity> oceanDataEntityList = oceanDataService.getAllOceanData();

        List<OceanDataDTOResponse> responseList = oceanDataEntityList.stream()
                .map(OceanDataDTOResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }
}
