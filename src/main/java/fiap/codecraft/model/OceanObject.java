package fiap.codecraft.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_OBJETO_OCEANO")
public class OceanObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_OBJETO_OCEANO")
    @SequenceGenerator(name="SEQ_ID_OBJETO_OCEANO", sequenceName = "SEQ_ID_OBJETO_OCEANO", allocationSize =  1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "tipo_objeto")
    private String objectType;

    @Column(name = "peso_objeto")
    private double objectWeight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OceanData.class)
    @JoinColumn(name = "dado_oceano_id")
    private OceanData oceanData;

    public OceanObject() {
    }

    public OceanObject(Integer id, String objectType, double objectWeight, OceanData oceanData) {
        this.id = id;
        this.objectType = objectType;
        this.objectWeight = objectWeight;
        this.oceanData = oceanData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public double getObjectWeight() {
        return objectWeight;
    }

    public void setObjectWeight(double objectWeight) {
        this.objectWeight = objectWeight;
    }

    public OceanData getOceanData() {
        return oceanData;
    }

    public void setOceanData(OceanData oceanData) {
        this.oceanData = oceanData;
    }
}
