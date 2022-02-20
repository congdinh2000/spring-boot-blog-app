package com.springboot.blog.config;

import com.springboot.blog.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    // inject dependency
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {
        // get jwt token from request
        String token = getJWTFromRequest(request);
        // validate token

        // get username from token

        // load user associated with token

        // set spring security
    }

    // Bear <accessToken>
    private String getJWTFromRequest(HttpServletRequest request)
    {
        String bearToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearToken) && bearToken.startsWith("Bearer"))
        {
            return bearToken.substring(7, bearToken.length());
        }
        return null;
    }
}
