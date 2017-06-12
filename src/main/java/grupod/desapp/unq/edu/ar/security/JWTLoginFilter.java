package grupod.desapp.unq.edu.ar.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


/**
 * Created by gabriel on 06/06/17.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
                                                throws AuthenticationException, IOException, ServletException {



        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                creds.getUsername(),
                creds.getPassword(),
                Collections.emptyList()
        );
        Authentication auti = null;
        try{
            auti = getAuthenticationManager().authenticate(user);
        }catch(BadCredentialsException ex){
            res.sendError(HttpStatus.UNAUTHORIZED.value(), "flashaste");
        }
        return auti;
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(req, res, auth);

        //Add authorization
        req.setAttribute("Token", res.getHeader("Authorization"));
        HttpServletRequest wrapped = new HttpServletRequestWrapper(req){
            @Override
            public String getHeader(String name) {
                String header = super.getHeader(name);
                return (header != null) ? header : super.getAttribute("Token").toString(); // Note: you can't use getParameterValues() here.
            }
        };

        chain.doFilter(wrapped,res);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
         if(((HttpServletRequest) req).getMethod().equals("OPTIONS")){
            chain.doFilter(req,res);
        } else{
             super.doFilter(req, res, chain);
         }

    }
}
