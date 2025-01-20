package upb.awj.demoSpringMH2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upb.awj.demoSpringMH2.model.Produs;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
}
