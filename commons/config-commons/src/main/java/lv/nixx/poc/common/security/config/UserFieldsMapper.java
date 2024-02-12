package lv.nixx.poc.common.security.config;

import lv.nixx.poc.common.ConfigAnnotationUtil;
import lv.nixx.poc.common.security.AppUser;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

class UserFieldsMapper {

    private final UserFields[] fields;

    public UserFieldsMapper(ApplicationContext applicationContext) {
        Annotation annotation = ConfigAnnotationUtil.getAnnotation(applicationContext, LoggedUserController.class);
        this.fields = (UserFields[]) AnnotationUtils.getValue(annotation, "fields");
    }

    public Map<String, Object> getCustomizedFields(AppUser currentUser) {

        Map<String, Object> userFields = new HashMap<>();
        for (UserFields f : this.fields) {
            switch (f) {
                case NAME -> userFields.put(f.getName(), currentUser.getUserName());
                case EMAIL -> userFields.put(f.getName(), currentUser.getEmail());
                case ROLES -> userFields.put(f.getName(), currentUser.getRoles());
                case AUTH_SOURCE -> userFields.put(f.getName(), currentUser.getAuthSource());
            }
        }

        return userFields;
    }

}
