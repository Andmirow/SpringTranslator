package translator.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import translator.entities.tables.Translater_rules;
import translator.entities.tables.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface RulesRepository extends JpaRepository<Translater_rules, Long> {//PagingAndSortingRepository<Translater_rules, Long>, JpaSpecificationExecutor<Translater_rules> {

    //@Query(value = "SELECT i FROM translater_rules WHERE i.users = ?")
    List<Translater_rules> findByUsers(Users user);

    Optional<Translater_rules> findById(Long id);
}
