package com.example.touristapi.config;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;
@Configuration
public class OpenApiConfig {
 @Bean OpenAPI api(){return new OpenAPI().components(new Components().addSecuritySchemes("CustomToken",
  new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name("X-Auth-Token")));}
}
