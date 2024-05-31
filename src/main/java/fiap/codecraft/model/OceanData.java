package fiap.codecraft.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_DADO_OCEANO")
public class OceanData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_DADO_OCEANO")
    @SequenceGenerator(name="SEQ_ID_DADO_OCEANO", sequenceName = "SEQ_ID_DADO_OCEANO", allocationSize =  1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "oceano")
    private String oceanType;

    @Column(name = "data_registro")
    private LocalDateTime recordDate;

    @Column(name = "temperatura_agua")
    private double waterTemperature;

    @Column(name = "nivel_poluicao_agua")
    private double waterPollutionLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "oceanData")
    private List<OceanObject> oceanObjects;

    public OceanData() {
    }

    public OceanData(Integer id, String oceanType, LocalDateTime recordDate, double waterTemperature, double waterPollutionLevel, List<OceanObject> oceanObjects) {
        this.id = id;
        this.oceanType = oceanType;
        this.recordDate = recordDate;
        this.waterTemperature = waterTemperature;
        this.waterPollutionLevel = waterPollutionLevel;
        this.oceanObjects = oceanObjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOceanType() {
        return oceanType;
    }

    public void setOceanType(String oceanType) {
        this.oceanType = oceanType;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public double getWaterPollutionLevel() {
        return waterPollutionLevel;
    }

    public void setWaterPollutionLevel(double waterPollutionLevel) {
        this.waterPollutionLevel = waterPollutionLevel;
    }

    public List<OceanObject> getOceanObjects() {
        return oceanObjects;
    }

    public void setOceanObjects(List<OceanObject> oceanObject) {
        this.oceanObjects = oceanObject;
    }
}
