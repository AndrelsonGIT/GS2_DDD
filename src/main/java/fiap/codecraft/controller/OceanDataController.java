package fiap.codecraft.controller;

import fiap.codecraft.DTO.request.OceanDataCreateDTORequest;
import fiap.codecraft.DTO.response.OceanDataDTOResponse;
import fiap.codecraft.model.OceanData;
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
        OceanData oceanData = oceanDataService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OceanDataDTOResponse(oceanData));
    }

    @GetMapping
    public ResponseEntity<List<OceanDataDTOResponse>> getOceanData(){
        List<OceanData> oceanDataList = oceanDataService.getAllOceanData();

        List<OceanDataDTOResponse> responseList = oceanDataList.stream()
                .map(OceanDataDTOResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }
}
