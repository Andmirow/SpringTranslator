package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import translator.entities.tables.Translater;

@Repository
public interface WordRepository extends JpaRepository<Translater, Long> {
}
