package com.example.demo.config


import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

//@Configuration
//@EnableWebMvc
//@OpenAPIDefinition
class SwaggerConfig {
//    @Bean
    fun api() : OpenAPI {
        val info = Info().title("API").description("API")
        return OpenAPI().info(info)

    }

}