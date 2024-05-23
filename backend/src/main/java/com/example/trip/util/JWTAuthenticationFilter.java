package com.example.trip.util;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private final JWTUtil jwtUtil;

	public JWTAuthenticationFilter(JWTUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String header = request.getHeader("Authorization");
		final String token = header != null && header.startsWith("Bearer ") ? header.substring(7) : null;

		if (token != null && jwtUtil.checkToken(token)) {
			String username = jwtUtil.getUserIdFromToken(token);

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				JWTAuthenticationToken authentication = new JWTAuthenticationToken(username, null, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(request, response);
	}
}
