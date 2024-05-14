package com.example.trip.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${jwt.access-token.expiretime}")
	private long accessTokenExpireTime;
	
	@Value("${jwt.refresh-token.expiretime}")
	private long refreshTokenExpireTime;
	
	private String salt = "your-salt-value";
	
	private String create(String userId, String subject, long expireTime) {
		Claims claims = Jwts.claims().setSubject(subject)
				.setExpiration(new Date(System.currentTimeMillis() + expireTime));

		claims.put("userID", userId);
		String jwt = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, this.generateKey()).compact();

		return jwt;
	}


	public String createAccessToken(String userId) {
		return create(userId, "access-token", accessTokenExpireTime);
	}

	public String createRefreshToken(String userId) {
		return create(userId, "refresh-token", refreshTokenExpireTime);
	}

	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = salt.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key;
	}

	public boolean checkToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
