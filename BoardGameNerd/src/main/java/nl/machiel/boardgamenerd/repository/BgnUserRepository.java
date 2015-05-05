package nl.machiel.boardgamenerd.repository;

import nl.machiel.boardgamenerd.model.BgnUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mdeswijger
 */
@Repository
public interface BgnUserRepository extends CrudRepository<BgnUser, Long> {
    BgnUser findByUsername(String username);
    BgnUser findByEmail(String email);
}
