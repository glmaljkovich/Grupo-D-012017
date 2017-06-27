package grupod.desapp.unq.edu.ar.security;

import grupod.desapp.unq.edu.ar.model.user.User;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by gabriel on 06/06/17.
 */
@Service
public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    private static final String SECRET = "totallynot1234";
    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";

    public static void addAuthentication(HttpServletRequest req, HttpServletResponse res, Authentication auth) {
        String JWT = Jwts.builder()
                .setSubject(auth.getName())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .claim("accessLevel", auth.getAuthorities().stream().findFirst().get().getAuthority())
                .setIssuedAt(new Date())
                .compact();
        res.addHeader(AUTHORIZATION, BEARER + JWT);
        req.setAttribute("token", JWT);

    }

    public static String getToken(User user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .claim("accessLevel", user.getAccessLevel().toString())
                .setIssuedAt(new Date())
                .compact();
    }

    public static Authentication getAuthentication(HttpServletRequest request) throws AuthenticationException, JwtException {
        Authentication auth;
        String token = request.getHeader(AUTHORIZATION);

        if (token == null || !token.startsWith("Bearer "))
            throw new AuthenticationCredentialsNotFoundException("No JWT token found in request headers");

        Jws<Claims> jwt = Jwts.parser()
                              .setSigningKey(SECRET)
                              .parseClaimsJws(token.replace(BEARER, ""));

        String user = jwt.getBody().getSubject();
        String accessLevel = jwt.getBody().get("accessLevel", String.class);

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(accessLevel);

        if(authorityList == null)
            auth = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        else
            auth = new UsernamePasswordAuthenticationToken(user, null, authorityList);

        return auth;

    }
}
