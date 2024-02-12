package lv.nixx.poc.common.security.config;

import io.swagger.v3.oas.annotations.Operation;
import lv.nixx.poc.common.security.LoggedUserService;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@Configuration
class LoggedUserControllerConfig {

    private final UserFieldsMapper userFieldsMapper;
    private final LoggedUserService loggedUserService;

    public LoggedUserControllerConfig(ApplicationContext applicationContext, LoggedUserService loggedUserService) {
        this.userFieldsMapper = new UserFieldsMapper(applicationContext);
        this.loggedUserService = loggedUserService;
    }

    @Bean
    @RouterOperation(operation = @Operation(operationId = "getLoggedUserInfo", summary = "Return logged user info", tags = {"Get logged User info"}))
    RouterFunction<ServerResponse> getLoggedUserInfoRoute() {
        return RouterFunctions.route(
                GET("/user").and(accept(MediaType.APPLICATION_JSON)),
                req -> ok().body(userFieldsMapper.getCustomizedFields(loggedUserService.getLoggedUser()))
        );
    }



}
