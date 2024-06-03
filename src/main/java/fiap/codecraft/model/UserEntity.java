package fiap.codecraft.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario_gs")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_completo")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private UserAddressEntity address;

    public UserEntity() {
    }

    public UserEntity(Integer id, String fullName, String email, String password, UserAddressEntity address) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAddressEntity getAddress() {
        return address;
    }

    public void setAddress(UserAddressEntity address) {
        this.address = address;
    }
}
