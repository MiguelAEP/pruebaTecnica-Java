package com.pruebatecnica.configuracion;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.pruebatecnica.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;


public class JwtTokenValidador extends OncePerRequestFilter {

    private JwtUtils jwtUtils;

    public JwtTokenValidador(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        String jwtFromHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwtFromHeader != null) {
            jwtFromHeader = jwtFromHeader.substring(7);

            DecodedJWT decodedJWT = jwtUtils.validarToken(jwtFromHeader);
            System.out.println("decodedJWT jwttokenvalidador" + decodedJWT);
            //obtendremos al usuario
            String userDecoded = jwtUtils.extractUserName(decodedJWT);
            //necesitamos obtener las authorizaciones
            String stringAuthorities = jwtUtils.getSpecificClaim(decodedJWT, "authorities").asString();

            //convertiremos las autorities a grantedAuthority
            //me ddara los permisos read, write ,delated separados por coma ","
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);
            System.out.println("authorities jwttokenvalidador" + authorities);

            //lo setearemos en el security context holder con sus permisos
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDecoded, null, authorities);
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);

        }

        filterChain.doFilter(request, response);

    }
}
