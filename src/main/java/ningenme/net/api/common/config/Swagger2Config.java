package ningenme.net.api.common.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

    private static final String HOST_NAME = "api.ningenme.net";

    private static final String PROTOCOL = "HTTPS";

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("ningenme.net.api")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/v1/.*"))
            .build()
            .host(HOST_NAME)
            .useDefaultResponseMessages(false)
            .protocols(Sets.newHashSet(PROTOCOL))
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("net-api")
            .description("趣味開発API一覧")
            .version("3.0.0")
            .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                                     .deepLinking(true)
                                     .displayRequestDuration(true)
                                     .defaultModelsExpandDepth(-1)
                                     .docExpansion(DocExpansion.LIST)
                                     .validatorUrl("")
                                     .filter(true)
                                     .build();
    }

    /**
     * application.yamlで静的リソースへのアクセスを禁止している。ただしswaggerだけは見れるようにする必要がある、
     * そのための設定。
     * @param resourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("swagger-ui.html")
                               .addResourceLocations("classpath:/META-INF/resources/");
        resourceHandlerRegistry.addResourceHandler("/webjars/**")
                               .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
