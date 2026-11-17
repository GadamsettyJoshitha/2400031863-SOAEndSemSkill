package com.example.touristapi.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class TokenAuthenticationFilterTest {
 @Test void missingTokenGets401()throws Exception{
  var f=new TokenAuthenticationFilter("known-token",new ObjectMapper());var q=new MockHttpServletRequest("GET","/api/tourists");var s=new MockHttpServletResponse();var c=mock(FilterChain.class);
  f.doFilter(q,s,c);assertEquals(401,s.getStatus());verifyNoInteractions(c);
 }
 @Test void invalidTokenGets401()throws Exception{
  var f=new TokenAuthenticationFilter("known-token",new ObjectMapper());var q=new MockHttpServletRequest("GET","/api/tourists");q.addHeader("X-Auth-Token","bad");var s=new MockHttpServletResponse();var c=mock(FilterChain.class);
  f.doFilter(q,s,c);assertEquals(401,s.getStatus());verifyNoInteractions(c);
 }
 @Test void validTokenContinues()throws Exception{
  var f=new TokenAuthenticationFilter("known-token",new ObjectMapper());var q=new MockHttpServletRequest("GET","/api/tourists");q.addHeader("X-Auth-Token","known-token");var s=new MockHttpServletResponse();var c=mock(FilterChain.class);
  f.doFilter(q,s,c);verify(c).doFilter(q,s);
 }
}
