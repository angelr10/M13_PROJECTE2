package com.capokar.es.capokar.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;
import java.util.Date;
import java.security.Key;
import com.capokar.es.capokar.Model.Cliente;

public class JwtUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(Cliente cliente) {
        return Jwts.builder()
                .setSubject(cliente.getNombre())
                .claim("id", cliente.getId_cliente())
                .claim("nombre", cliente.getNombre())
                .claim("apellido", cliente.getApellido())
                .claim("direccion", cliente.getDireccion())
                .claim("poblacion", cliente.getPoblacion())
                .claim("telefono", cliente.getTelefono())
                .claim("email", cliente.getEmail())
                .claim("DNI", cliente.getDNI())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validez
                .signWith(SECRET_KEY)
                .compact();
    }
}
