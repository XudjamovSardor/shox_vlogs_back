package uz.shoxvlogs.shoxvlogs.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.shoxvlogs.shoxvlogs.intity.Lavozim;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expirationDate}")
    private Long expirationDate;
    @Value("${security.jwt.expirationDateRememberMe}")
    private Long expirationDateRememberMe;

    public String generateToken(Authentication authentication, Boolean rememberMe){

        Map<String, Object> map = new HashMap<>();
        if(!authentication.getAuthorities().isEmpty())
            map.put("role", authentication
                            .getAuthorities()
                            .stream()
                            .findFirst()
                            .get().toString());


        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(Date.from(Instant.now()))
                .addClaims(map)
                .setExpiration(Date.from(Instant.now().plusSeconds(rememberMe !=null && rememberMe ? expirationDateRememberMe : expirationDate)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validate(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return  true;

        } catch (Exception ex){
        }
        return false;
    }
    private Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String getLoginFromToken(String token){
       return (String) getClaimsFromToken(token)
               .getSubject();
    }

    public Lavozim getLavozimFromToken(String token){
       return Lavozim.valueOf ((String) getClaimsFromToken(token)
               .get("role"));
    }

}
