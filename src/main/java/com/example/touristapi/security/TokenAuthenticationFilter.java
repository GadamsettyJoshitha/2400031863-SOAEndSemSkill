package com.example.touristapi.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
 private final List<String> tokens; private final ObjectMapper mapper;
 public TokenAuthenticationFilter(@Value("${app.security.tokens:}") String configured,ObjectMapper mapper){
  this.tokens=Arrays.stream(configured.split(",")).map(String::trim).filter(s->!s.isBlank()).toList(); this.mapper=mapper;
 }
 @Override protected boolean shouldNotFilter(HttpServletRequest req){return !"/api/tourists".equals(req.getServletPath());}
 @Override protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException{
  String incoming=req.getHeader("X-Auth-Token");
  if(incoming==null||incoming.isBlank()){reject(res,"Missing X-Auth-Token");return;}
  boolean ok=tokens.stream().anyMatch(t->MessageDigest.isEqual(incoming.getBytes(StandardCharsets.UTF_8),t.getBytes(StandardCharsets.UTF_8)));
  if(!ok){reject(res,"Invalid token");return;} chain.doFilter(req,res);
 }
 private void reject(HttpServletResponse res,String message)throws IOException{
  res.setStatus(401);res.setContentType("application/json");
  mapper.writeValue(res.getOutputStream(),Map.of("status",401,"error","Unauthorized","message",message));
 }
}
