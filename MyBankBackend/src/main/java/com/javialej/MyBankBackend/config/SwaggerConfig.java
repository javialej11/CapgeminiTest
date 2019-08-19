package com.javialej.MyBankBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    
    @Bean
    public Docket API() {
        return new Docket(DocumentationType.SWAGGER_2)       
    		 .apiInfo(metaData())
    		 .select()
    		 	.paths(PathSelectors.regex("/.*"))
    		 	.apis(RequestHandlerSelectors.any())
    		 	.build();
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("My Bank REST API")
            .description("\"Spring Boot REST API for My Bank Capgemini Test\"")
            .version("1.0.0")
            .license("MIT License")
            .licenseUrl("https://opensource.org/licenses/MIT")
            .contact(new Contact("Javier Alejandro Perez", "https://https://github.com/javialej11", "ja.perezf11@gmail.com"))
            .build();
    }
}