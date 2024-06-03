package fiap.codecraft.repository;

import fiap.codecraft.model.UserEntity;
import fiap.codecraft.model.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<UserTokenEntity, Integer> {
    UserTokenEntity findByUserId(int id);
}
