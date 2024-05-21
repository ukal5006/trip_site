//package com.example.trip.util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//public class SecurityConfig {
//
//    private final JWTUtil jwtUtil;
//
//    public SecurityConfig(JWTUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    String[] AUTH_LIST = {
//        "/user/login",
//        "/user/refresh",
//        "/v3/api-docs/**", 
//        "/swagger-ui/**",
//        "/swagger-ui.html",
//        "/swagger-resources/**",
//        "/webjars/**",
//        "/attraction/randomList/**",
//        "attraction/inRange/**"
//    };
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // CORS 설정을 활성화
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers(AUTH_LIST)
//                .permitAll()
//                .anyRequest().authenticated())
//            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public JWTAuthenticationFilter jwtAuthenticationFilter() {
//        return new JWTAuthenticationFilter(jwtUtil);
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*");  // 프론트엔드 도메인을 명시적으로 설정
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}

package com.example.trip.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
	
    String[] AUTH_LIST = {
            "/user/login",
            "/user/refresh",
            "/v3/api-docs/**", 
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",
            "/attraction/randomList/**",
            "/attraction/inRange/**",
            "/attraction/randomRestaurant/**",
            "/attraction/getTop3/**",
            "/bot/chat/**",
            "/brewery/**",
            "/user/**",
            "/board/**",
            "/wishlist/**",
            "/review/**",
            "/comment/**",
            "/notice/**",
            "/userBoard/**"
            
        };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated()
            )
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .formLogin(formLogin -> formLogin.disable())
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}