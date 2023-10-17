package com.web2.bookbuzz.auth.old;
// package com.web2.bookbuzz.auth;

// import java.util.Date;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.ExpiredJwtException;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import javax.servlet.http.HttpServletRequest;


// @Service
// public class AuthenticationService {

//     @Value("${jwt.secret}")
//     private String jwtSecret;

//     @Value("${jwt.expirationMs}")
//     static long jwtExpirationMs;

//     private final CustomUserDetailsService customUserDetailsService;

//     public AuthenticationService(CustomUserDetailsService customUserDetailsService) {
//         this.customUserDetailsService = customUserDetailsService;
//     }

//     public String generateJwtToken(UserDetails userDetails) {
//         Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationMs);
//         return Jwts.builder()
//                 .setSubject(userDetails.getUsername())
//                 .setExpiration(expirationDate)
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     public Authentication getAuthentication(HttpServletRequest request) {
//         String token = request.getHeader("Authorization");
//         if (token != null && token.startsWith("Bearer ")) {
//             token = token.substring(7);
//             try {
//                 Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//                 String username = claims.getSubject();
//                 UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//                 if (isValidToken(claims, userDetails)) {
//                     return new UsernamePasswordAuthenticationToken(userDetails, null,
//                             userDetails.getAuthorities());
//                 }
//             } catch (ExpiredJwtException e) {
//                 throw new BadCredentialsException("Token expired");
//             } catch (Exception e) {
//                 throw new BadCredentialsException("Invalid token");
//             }
//         }
//         return null; // Token inválido ou não fornecido
//     }

//     private boolean isValidToken(Claims claims, UserDetails userDetails) {
//         // Implemente a lógica para validar as informações do token, como roles, por exemplo.
//         // Compare as informações do token com as informações do usuário obtidas do UserDetails.
//         // Se tudo estiver válido, retorne true, caso contrário, retorne false.
//         return true; // Para fins de exemplo, sempre consideramos o token válido.
//     }
// }