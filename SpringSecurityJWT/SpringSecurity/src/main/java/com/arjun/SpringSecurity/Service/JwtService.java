package com.arjun.SpringSecurity.Service;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey;

    public JwtService(){
        secretKey = generateSecretKey();
    }

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims) //Adds extra data here none
                .setSubject(username) // Sets who the token is for
                .setIssuedAt(new Date(System.currentTimeMillis())) // current time when the token is generated
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3)) // token expires in 3 mins
                .signWith(getKey(), SignatureAlgorithm.HS256).compact(); // sign and convert to a compact string
    }

    public String generateSecretKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Secret Key: "+secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded()); // Converts key bytes into readable Base64 string
        }catch(NoSuchAlgorithmException e){
           throw new RuntimeException("Error generating secret key:",e) ;
        }
    }

    // Converts the stored secret key string back into a usable key object
    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // A generic template function to extract claims like subject, expiration date which we had set inside generateToken
    private <T> T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getKey()) // uses your secret key to verify the signature.
                .build()
                .parseClaimsJws(token) // parses token, checks if valid
                .getBody(); // gets all claims
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


}
