package biz.starhotel.platform.star_hotel_platform.shared.infrastructure.documentation.openapi.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfiguration {
  @Bean
  public OpenAPI learningPlatformOpenApi() {
    // General configuration
    var openApi = new OpenAPI();
    openApi
        .info(new Info()
            .title("Learning Platform API")
            .description("Learning Platform application REST API documentation.")
            .version("v1.0.0")
            .license(new License().name("Apache 2.0")
                .url("https://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("Learning Platform wiki Documentation")
            .url("https://github.com/upc-is-si729/daos-language-reference"));

    // Return OpenAPI configuration object with all the settings
    return openApi;
  }
}
