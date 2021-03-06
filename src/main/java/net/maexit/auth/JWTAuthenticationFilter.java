package net.maexit.auth;

/**
 * Created by arusov on 09.03.2018.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.maexit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private net.maexit.entity.User creds;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService=userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            creds = new ObjectMapper()
                    .readValue(req.getInputStream(), net.maexit.entity.User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPwd(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityUtils.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityUtils.SECRET.getBytes())
                .compact();
        res.addHeader(SecurityUtils.HEADER_STRING, SecurityUtils.TOKEN_PREFIX + token);
        res.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        StringBuilder sb = new StringBuilder();

        net.maexit.entity.User user = userService.findByEmail(creds.getEmail());

        sb.append("{");
        sb.append("\"token\" : \"" + token + "\",");
        sb.append("\"email\" : \"" + user.getEmail() + "\",");
        sb.append("\"type\" : " + user.getType() + "");
        sb.append("}");
        res.getWriter().write(sb.toString());
    }
}