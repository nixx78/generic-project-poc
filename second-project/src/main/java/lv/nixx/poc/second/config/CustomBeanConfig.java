package lv.nixx.poc.second.config;

import lv.nixx.poc.second.service.CustomService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;

@Configuration
public class CustomBeanConfig {

    public CustomBeanConfig(GenericWebApplicationContext context) {
        context.registerBean("firstService", CustomService.class, "fistServiceProcessor");
        context.registerBean("secondService", CustomService.class, "secondServiceProcessor");
    }


}
