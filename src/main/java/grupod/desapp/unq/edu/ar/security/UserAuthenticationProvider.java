package grupod.desapp.unq.edu.ar.security;

import grupod.desapp.unq.edu.ar.model.user.User;
import grupod.desapp.unq.edu.ar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by gabriel on 06/06/17.
 */
@Service
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate( Authentication authentication) throws AuthenticationException {
            User user = new User((String) authentication.getPrincipal(), (String) authentication.getCredentials(), "");
            User loggedUser = userService.login(user);
            return new UsernamePasswordAuthenticationToken(loggedUser.getUsername(), loggedUser.getPassword(), Arrays.asList(new SimpleGrantedAuthority(loggedUser.getAccessLevel().toString())));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
