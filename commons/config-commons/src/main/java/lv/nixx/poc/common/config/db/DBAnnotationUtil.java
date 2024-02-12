package lv.nixx.poc.common.config.db;

import lv.nixx.poc.common.ConfigAnnotationUtil;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

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
            return ConfigAnnotationUtil.getAnnotation(annotationType, beanFactory.getBeansWithAnnotation(annotationType));
        }
    }
    public static String[] getPackagesToScan(ApplicationContext applicationContext, Class<? extends Annotation> annotationType) {
        Annotation annotation = getAnnotation(applicationContext, annotationType);
        return (String[]) AnnotationUtils.getValue(annotation, "packageToScan");
    }



}
