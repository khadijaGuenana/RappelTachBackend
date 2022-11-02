package com.myproject.RappeltacheBack.Security.Filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.RappeltacheBack.Security.JWTUtil;
import com.myproject.RappeltacheBack.Security.Service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data  @NoArgsConstructor
public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;


    public JwtAuthentificationFilter(AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;


    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
       String username=request.getParameter("username");
       String password =request.getParameter("password");
        System.out.println("CH HAJJJJJJJJJA  "+username);
        System.out.println(password);
        UsernamePasswordAuthenticationToken authenticationToken=
                  new UsernamePasswordAuthenticationToken(username,password);

        System.out.println(authenticationToken.getDetails());

        return authenticationManager.authenticate(authenticationToken);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
      System.out.println("sucessfulAutentication");
        User user= (User) authResult.getPrincipal();
        Algorithm algo1=Algorithm.HMAC256(JWTUtil.SECRET);
        String jwtAccesToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(request.getRequestURI().toString())
                .sign(algo1)  ;
        String jwtRefreshTokenToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_REFRESH_TOKEN))
                .withIssuer(request.getRequestURI().toString())
                .sign(algo1)  ;
        Map<String,String> idTocken =new HashMap<>();
        idTocken.put("access-token",jwtAccesToken);
        idTocken.put("refresh-token",jwtRefreshTokenToken);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(),idTocken);
       // response.setHeader("Authorization" ,jwtAccesToken);
       // super.successfulAuthentication(request,response,chain,authResult)

    }
}
