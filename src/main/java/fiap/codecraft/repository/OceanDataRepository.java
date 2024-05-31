package fiap.codecraft.repository;

import fiap.codecraft.model.OceanDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OceanDataRepository extends JpaRepository<OceanDataEntity, Integer> {
}
