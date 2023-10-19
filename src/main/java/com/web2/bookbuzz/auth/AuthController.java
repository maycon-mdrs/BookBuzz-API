package com.web2.bookbuzz.auth;

import com.web2.bookbuzz.dto.requests.LoginRequestDTO;
import com.web2.bookbuzz.dto.responses.ErrorResponseDTO;
import com.web2.bookbuzz.dto.responses.LoginResponseDTO;
import com.web2.bookbuzz.models.UserModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequestDTO loginReq) {

        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            UserModel user = new UserModel(email, "", email, email, null);
            String token = jwtUtil.createToken(user);
            LoginResponseDTO loginRes = new LoginResponseDTO(email, token);

            return ResponseEntity.ok(loginRes);

        } catch (BadCredentialsException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(HttpStatus.BAD_REQUEST,
                    "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (InternalAuthenticationServiceException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(HttpStatus.BAD_REQUEST, "Email não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        catch (Exception e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}