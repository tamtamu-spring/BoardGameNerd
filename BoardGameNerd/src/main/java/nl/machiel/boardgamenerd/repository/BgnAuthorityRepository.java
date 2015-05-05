package nl.machiel.boardgamenerd.repository;

import nl.machiel.boardgamenerd.model.BgnAuthority;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * @author mdeswijger
 */
public interface BgnAuthorityRepository extends CrudRepository<BgnAuthority, String> {
    Set<BgnAuthority> findByBgnAuthorityId_Username(String username);
}
