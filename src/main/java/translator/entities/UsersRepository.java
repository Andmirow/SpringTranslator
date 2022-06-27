package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import translator.entities.tables.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
