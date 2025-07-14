package com.grepp.spring.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApiSpec(){
        return new OpenAPI()
                   .info(new Info()
                             .title("Grepp API 문서")
                             .description("에러코드는 [링크] 를 참조해 주세요")
                             .version("v1.0.0"))
                   .servers(List.of(new Server().url("/")))
                   .components(
                       new Components()
                           .addSecuritySchemes("bearer-auth",
                               new SecurityScheme()
                                   .name("bearer-auth")
                                   .type(Type.HTTP)
                                   .scheme("bearer")
                                   .bearerFormat("JWT")
                                   .description("JWT 를 입력하세요. Bearer 는 생략하세요"))
                   )
                   .addSecurityItem(new SecurityRequirement().addList("bearer-auth"));
    
    }
}
