package fiap.codecraft.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_token_usuario")
public class UserTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UserEntity user;

    public UserTokenEntity() {
    }

    public UserTokenEntity(Integer id, String token, UserEntity user) {
        this.id = id;
        this.token = token;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
