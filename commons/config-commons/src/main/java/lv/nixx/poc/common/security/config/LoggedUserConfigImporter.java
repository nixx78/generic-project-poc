package lv.nixx.poc.common.security.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

class LoggedUserConfigImporter implements ImportSelector {
    @Override
    public String[] selectImports(@NonNull AnnotationMetadata metadata) {
        return new String[]{
                LoggedUserControllerConfig.class.getCanonicalName(),
                LoggedUserServiceConfig.class.getCanonicalName()
        };
    }

}
