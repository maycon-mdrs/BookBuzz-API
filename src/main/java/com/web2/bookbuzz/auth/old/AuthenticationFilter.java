package com.web2.bookbuzz.auth.old;
// package com.web2.bookbuzz.auth;

// import java.io.IOException;
// import java.util.Date;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//     private final AuthenticationManager authenticationManager;
//     private final ObjectMapper objectMapper;
//     private final String jwtSecret;

//     public AuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper,
//             String jwtSecret) {
//         this.authenticationManager = authenticationManager;
//         this.objectMapper = objectMapper;
//         this.jwtSecret = jwtSecret;
//         super.setFilterProcessesUrl("/auth/login"); // Define a URL de login personalizada
//     }

//     // @Override
//     // public Authentication attemptAuthentication(HttpServletRequest request,
//     // HttpServletResponse response) {
//     // try {
//     // UserCredentials userCredentials =
//     // objectMapper.readValue(request.getInputStream(), UserCredentials.class);

//     // if (userCredentials.getUsername() == null || userCredentials.getPassword() ==
//     // null) {
//     // throw new RuntimeException("Username and password are required");
//     // }

//     // Authentication authentication = new UsernamePasswordAuthenticationToken(
//     // userCredentials.getUsername(),
//     // userCredentials.getPassword());

//     // return authenticationManager.authenticate(authentication);
//     // } catch (IOException e) {
//     // throw new RuntimeException(e);
//     // }
//     // }

//     // @Override
//     // protected void successfulAuthentication(HttpServletRequest request,
//     // HttpServletResponse response,
//     // FilterChain chain, Authentication authResult) throws IOException,
//     // ServletException {
//     // String username = authResult.getName();
//     // Date expirationDate = new Date(System.currentTimeMillis() +
//     // AuthenticationService.jwtExpirationMs);

//     // String token = Jwts.builder()
//     // .setSubject(username)
//     // .setExpiration(expirationDate)
//     // .signWith(SignatureAlgorithm.HS512, jwtSecret)
//     // .compact();

//     // response.addHeader("Authorization", "Bearer " + token);
//     // }

//     // @Override
//     // protected void unsuccessfulAuthentication(HttpServletRequest request,
//     // HttpServletResponse response,
//     // org.springframework.security.core.AuthenticationException failed)
//     // throws IOException, ServletException {
//     // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, failed.getMessage());
//     // }
// }