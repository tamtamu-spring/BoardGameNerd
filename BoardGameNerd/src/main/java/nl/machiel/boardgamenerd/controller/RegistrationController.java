package nl.machiel.boardgamenerd.controller;

import nl.machiel.boardgamenerd.model.BgnAuthority;
import nl.machiel.boardgamenerd.model.BgnUser;
import nl.machiel.boardgamenerd.repository.BgnAuthorityRepository;
import nl.machiel.boardgamenerd.repository.BgnUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class RegistrationController extends WebMvcConfigurerAdapter {
    @Autowired
    private BgnUserRepository userRepository;

    @Autowired
    private BgnAuthorityRepository authorityRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(BgnUser bgnUser) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(@Valid BgnUser bgnUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        bgnUser.setEnabled(true);
        bgnUser.setAccountNonExpired(true);
        bgnUser.setAccountNonLocked(true);
        bgnUser.setCredentialsNonExpired(true);
        bgnUser.setPassword(new BCryptPasswordEncoder().encode(bgnUser.getPassword()));
        userRepository.save(bgnUser); // TODO: Handle Database exceptions, like org.hibernate.exception.ConstraintViolationException

        BgnAuthority authority = new BgnAuthority(bgnUser.getUsername(), "ROLE_USER");
        authorityRepository.save(authority);

        bgnUser.getBgnAuthorities().add(authority);

        model.addAttribute("message", "Successfully registered. Welcome @ BGN!");
        return "home";
    }
}
