package com.example.minhaapi.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Api Title")
                    .description("Api Definition")
                    .version("1.0.0")
                    .contact(
                        Contact().apply {
                            name = "George Pinchemel"
                            url = "https://www.linkedin.com/in/george-pinchemel/"
                        }
                    )
                    .license(
                        License().apply {
                            name = "GitHub"
                            url = "https://github.com/GeorgePinchemel/aula_api_george1.git"
                        }
                    )
            )
    }
}