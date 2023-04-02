package com.example.tapselltask.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun productApp():Docket{
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.tapselltask"))
            .paths(PathSelectors.regex("/api/v1.*"))
            .build()
            .apiInfo(metaInfo())

    }

    private fun metaInfo(): ApiInfo? {

        return ApiInfo(
            "Tapsell backer entry task",
            "This single api is for tapsell backend team entry task documented using swagger",
            "1.0",
            "Terms of Service",
            "saman",
            "Apache License Version 2.0",
            "https://www.apache.org/license.html"

        )
    }
}