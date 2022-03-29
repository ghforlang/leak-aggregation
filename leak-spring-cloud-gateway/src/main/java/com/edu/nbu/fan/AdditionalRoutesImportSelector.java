package com.edu.nbu.fan;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/29-4:54 PM
 * @since 1.0
 */
public class AdditionalRoutesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (ClassUtils.isPresent("org.springframework.cloud.gateway.sample.AdditionalRoutes", null)) {
            return new String[] { "org.springframework.cloud.gateway.sample.AdditionalRoutes" };
        }
        return new String[0];
    }
}
