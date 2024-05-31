package fiap.codecraft.repository;

import fiap.codecraft.model.OceanObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OceanObjectRepository extends JpaRepository<OceanObject, Integer> {
}
