package nl.machiel.boardgamenerd.service;

import nl.machiel.boardgamenerd.model.BgnAuthority;
import nl.machiel.boardgamenerd.model.BgnUser;
import nl.machiel.boardgamenerd.repository.BgnAuthorityRepository;
import nl.machiel.boardgamenerd.repository.BgnUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author mdeswijger
 */
@Service
public class BgnUserDetailsService implements UserDetailsService {
    @Autowired
    private BgnUserRepository userRepository;

    @Autowired
    private BgnAuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BgnUser user = userRepository.findByUsername(username);
        Set<BgnAuthority> authorities = authorityRepository.findByBgnAuthorityId_Username(username);
        user.getBgnAuthorities().addAll(authorities);

        return user;
    }
}
