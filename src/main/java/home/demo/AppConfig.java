package home.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource(value = { "classpath:application.properties", "classpath:build.properties" })
public class AppConfig extends WebMvcConfigurerAdapter {

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	// registry.addResourceHandler("/webjars/**",
	// "classpath:/META-INF/resources/webjars/");
	// }
}
