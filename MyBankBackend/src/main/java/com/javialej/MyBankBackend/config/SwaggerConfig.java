package com.javialej.MyBankBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.javialej.MyBankBackend.MyBankBackendApplication;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.javialej.MyBankBackend.controllers"))
	        .paths(regex(MyBankBackendApplication.API + "/*"))
	        .build()
	        .apiInfo(metaData());
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
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}