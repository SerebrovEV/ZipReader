package org.reader.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DatabaseInitializer implements InitializingBean {
    @Autowired
    ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
        final Resource[] resources = context.getResources("classpath*:text/*");
        final Set<String> filePaths = findInputFileNames(resources);
        final Set<String> configurations = createConfigurations(filePaths);
    }

    private  Set<String> createConfigurations(final Set<String> filePaths) throws Exception {
        final Set<String> configurations = new HashSet<>();
        for(final String path : filePaths){
            final Resource resource = context.getResource(path);
            log.info(resource.getFilename());
            configurations.add(resource.getFilename());
        }
        return configurations;
    }

    public Set<String> findInputFileNames(final Resource[] inputDirectoryResources) throws IOException {
        return Arrays.stream(inputDirectoryResources)
                .map(resource -> extractURI(resource))
                .collect(Collectors.toSet());
    }

    private String extractURI(Resource resource){
        try {
            return resource.getURI().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
