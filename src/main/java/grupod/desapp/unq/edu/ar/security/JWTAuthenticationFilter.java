package grupod.desapp.unq.edu.ar.security;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gabriel on 06/06/17.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if(((HttpServletRequest) request).getMethod().equals("OPTIONS")){
            filterChain.doFilter(request,response);
        }else{
            try{
                Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest)request);
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

                filterChain.doFilter(request,response);
            }catch (Exception ex){
                ((HttpServletResponse) response).sendError(HttpStatus.UNAUTHORIZED.value(), "Your Credentials aren't valid.");
            }
        }
    }
}
