package com.example.typeexcludefilter.filter;

import com.example.typeexcludefilter.component.A;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;


/**
 * 排除特定bean 注入
 */
@EqualsAndHashCode
public class CustomerTypeExcludeFilter extends TypeExcludeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        String className = metadataReader.getClassMetadata().getClassName();


//        return className.contains(A.class.getName());
        return false;
    }


}