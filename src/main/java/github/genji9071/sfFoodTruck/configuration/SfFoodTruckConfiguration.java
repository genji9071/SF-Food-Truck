package github.genji9071.sfFoodTruck.configuration;

import github.genji9071.sfFoodTruck.interceptor.SfFoodTruckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SfFoodTruckConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SfFoodTruckInterceptor()).addPathPatterns("/**");
    }
}
