package lv.nixx.poc.common.security.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({LoggedUserConfigImporter.class})
public @interface LoggedUserController {

    UserFields[] fields() default {UserFields.NAME};
}
