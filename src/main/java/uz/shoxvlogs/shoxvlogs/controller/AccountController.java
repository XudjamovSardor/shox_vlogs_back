package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import uz.shoxvlogs.shoxvlogs.intity.Lavozim;
import uz.shoxvlogs.shoxvlogs.intity.User;
import uz.shoxvlogs.shoxvlogs.security.JwtUtil;
import uz.shoxvlogs.shoxvlogs.security.Token;
import uz.shoxvlogs.shoxvlogs.security.UserSignDTO;
import uz.shoxvlogs.shoxvlogs.service.UserService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(value = "*", maxAge = 3600)
public class AccountController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;


    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserSignDTO user){
        Authentication authentication =   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication, user.getRememberMe());
        return ResponseEntity.ok(new Token(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user){
        user.setAktiv(true);
        user.setRegTime(LocalDateTime.now());
        user.setLavozimlar(Collections.singleton(Lavozim.USER));
        user.setUpdateTime(LocalDateTime.now());
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return ResponseEntity.ok(userService.getUserByLogin(principal.getName()));
    }
}
