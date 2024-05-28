package solo.Hamburgueseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.Hamburgueseria.entity.Hamburguesa;


public interface HamburguesaRepository extends JpaRepository<Hamburguesa, Long> {
}
