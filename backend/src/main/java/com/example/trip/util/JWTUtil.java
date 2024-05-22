package com.example.trip.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JWTUtil {
	private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);
	private Set<String> tokenBlacklist = new HashSet<>();

	@Value("${jwt.access-token.expiretime}")
	private long accessTokenExpireTime;

	@Value("${jwt.refresh-token.expiretime}")
	private long refreshTokenExpireTime;

	@Value("${jwt.secret-key}")
	private String secret;

	private SecretKey secretKey;

	@PostConstruct
	public void init() {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	private String create(String userId, String subject, long expireTime) {
		Claims claims = Jwts.claims().setSubject(subject)
				.setExpiration(new Date(System.currentTimeMillis() + expireTime));

		claims.put("userID", userId);
		return Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims)
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();
	}

	public String createAccessToken(String userId) {
		return create(userId, "access-token", accessTokenExpireTime);
	}

	public String createRefreshToken(String userId) {
		return create(userId, "refresh-token", refreshTokenExpireTime);
	}

	public boolean isTokenValid(String token) {
		try {
			Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return !claims.getBody().getExpiration().before(new Date());
		}
		catch (Exception e) {
			return false;
		}
	}

	public String refreshAccessToken(String refreshToken) {
		try {
			Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(refreshToken);

			String userId = claims.getBody().get("userID", String.class);
			return createAccessToken(userId);
		}
		catch (Exception e) {
			logger.error("Error refreshing access token", e);
			return null;
		}
	}

	public boolean checkToken(String token) {
		try {
			if (tokenBlacklist.contains(token)) {
				logger.warn("Token is blacklisted");
				return false;
			}
			Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;
		}
		catch (Exception e) {
			logger.error("Invalid JWT token", e);
			return false;
		}
	}

	public String getUserIdFromToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return claims.getBody().get("userID", String.class);
		}
		catch (Exception e) {
			logger.error("Error getting userId from token", e);
			return null;
		}
	}

	public void invalidateToken(String token) {
		tokenBlacklist.add(token);
	}
}
