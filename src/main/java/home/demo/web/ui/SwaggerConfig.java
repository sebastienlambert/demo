package home.demo.web.ui;

import static com.google.common.base.Predicates.containsPattern;
import static com.google.common.base.Predicates.or;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import home.demo.ws.web.api.GreetingController;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = { GreetingController.class })
public class SwaggerConfig {

	@SuppressWarnings("unchecked")
	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.paths(or(containsPattern("/api*"))).build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("My Demo API", 
				"This is a demo to play around",
				"1.0.0", // need to import it from pom.xml
				"Free of use",
				"myemail@yahoo.com",
				"No license required",
				"http://demo.com");
	}
}
