package org.anyframe.cloud;

import static springfox.documentation.builders.PathSelectors.regex;

import org.anyframe.cloud.infrastructure.api.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@SpringBootApplication
@Import({SwaggerConfiguration.class})
//@PropertySource(value="config/rabbit.properties")
public class CargoTrackerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoTrackerUserApplication.class, args);
    }

    @Bean
    public Predicate<String> swaggerPaths() {
      return regex("/users.*|/sign.*|/log.*|/withdrawal.*|/cargo.*");
    }

    @Bean
    public ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title("Cargo User API")
              .description("Cargo Tracker User API")
              .contact("Anyframe Cloud Edition")
              .license("Anyframe Cloud Ed.")
              .version("1.0")
              .build();
    }
}
