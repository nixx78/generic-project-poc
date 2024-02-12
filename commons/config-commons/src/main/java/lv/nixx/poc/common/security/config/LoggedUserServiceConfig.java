package lv.nixx.poc.common.security.config;

import lv.nixx.poc.common.security.LoggedUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggedUserServiceConfig {
    @Bean
    LoggedUserService loggedUserService() {
        return new LoggedUserService();
    }

}
