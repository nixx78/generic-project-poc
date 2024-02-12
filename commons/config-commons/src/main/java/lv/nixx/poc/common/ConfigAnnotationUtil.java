package lv.nixx.poc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.util.Map;

public class ConfigAnnotationUtil {

    public static Annotation getAnnotation(@NonNull ApplicationContext applicationContext, @NonNull Class<? extends Annotation> annotationType) {

        Assert.notNull(applicationContext, "Can't retrieve annotation from 'null' application context");
        Assert.notNull(annotationType, "Annotation class can't be 'null'");

        return getAnnotation(annotationType, applicationContext.getBeansWithAnnotation(annotationType));
    }

    public static Annotation getAnnotation(Class<? extends Annotation> annotationType, Map<String, Object> beansWithAnnotation) {
        if (beansWithAnnotation.size() > 1) {
            throw new IllegalStateException("Application run fail, only single annotation [" + annotationType.getSimpleName() + "] allowed in Application");
        }

        Object bean = beansWithAnnotation.values().stream().findFirst().orElse(null);
        if (bean == null) {
            return null;
        } else {
            return AnnotationUtils.findAnnotation(bean.getClass(), annotationType);
        }
    }

}
