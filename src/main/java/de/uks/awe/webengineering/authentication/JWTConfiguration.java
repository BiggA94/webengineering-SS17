package de.uks.awe.webengineering.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexw on 16.05.2017.
 */
@Configuration
public class JWTConfiguration {
    @Autowired
    private AuthenticationService authenticationService;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JWTFilter(authenticationService));
        bean.addUrlPatterns("/api/*");
        return bean;
    }
}
