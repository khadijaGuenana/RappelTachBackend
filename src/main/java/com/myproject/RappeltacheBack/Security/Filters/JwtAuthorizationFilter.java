package com.myproject.RappeltacheBack.Security.Filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.myproject.RappeltacheBack.Security.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         if(request.getServletPath().equals("/refreshToken")){
             filterChain.doFilter(request,response);

         }
         else {
             String authorizationToken=request.getHeader(JWTUtil.AUTH_HEADER);
             if(authorizationToken!=null &&authorizationToken.startsWith(JWTUtil.PREFIX)){
                 try {
                     String jwt=authorizationToken.substring(JWTUtil.PREFIX.length());
                     Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
                     JWTVerifier jwtVerifier= JWT.require(algorithm).build();
                     DecodedJWT decodedJWT =jwtVerifier.verify(jwt);
                     String username=decodedJWT.getSubject();
                     UsernamePasswordAuthenticationToken authenticationToken=
                             new UsernamePasswordAuthenticationToken(username,null,null);
                     SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                     filterChain.doFilter(request,response);

                 }catch (Exception e){
                     response.setHeader("error-message",e.getMessage());
                     response.sendError(HttpServletResponse.SC_FORBIDDEN);

                 }
             }
             else {
                 filterChain.doFilter(request,response);
             }
         }

         }

}
