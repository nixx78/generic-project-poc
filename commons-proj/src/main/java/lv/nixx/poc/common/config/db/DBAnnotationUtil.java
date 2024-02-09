package lv.nixx.poc.common.config.db;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

public class DBAnnotationUtil {

    public static boolean loadJPABeans(ListableBeanFactory beanFactory, Class<? extends Annotation> annotationType) {
        Annotation annotation = getAnnotation(beanFactory, annotationType);
        if (annotation == null) {
            return false;
        } else {
            try {
                Method jpaSupport = annotation.annotationType().getMethod("jpaSupport", null);

                return (Boolean) jpaSupport.invoke(annotation, null);
            } catch (Exception e) {
                throw new IllegalStateException("Application run fail, problem with annotation: " + annotationType.getSimpleName(), e);
            }
        }
    }

    private static Annotation getAnnotation(ListableBeanFactory beanFactory, Class<? extends Annotation> annotationType) {
        if (beanFactory == null) {
            return null;
        } else {
            return getAnnotation(annotationType, beanFactory.getBeansWithAnnotation(annotationType));
        }
    }

    public static String[] getPackagesToScan(ApplicationContext applicationContext, Class<? extends Annotation> annotationType) {
        Annotation annotation = getAnnotation(applicationContext, annotationType);
        return (String[]) AnnotationUtils.getValue(annotation, "packageToScan");
    }

    private static Annotation getAnnotation(ApplicationContext applicationContext, Class<? extends Annotation> annotationType) {
        if (applicationContext == null) {
            return null;
        } else {
            return getAnnotation(annotationType, applicationContext.getBeansWithAnnotation(annotationType));
        }
    }

    private static Annotation getAnnotation(Class<? extends Annotation> annotationType, Map<String, Object> beansWithAnnotation) {
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
