package org.reader.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
@Service
public class ReaderService {

//    private final InputFile inputFile;

    private final ApplicationContext context;

    public ReaderService(ApplicationContext context) {
        this.context = context;
    }

    public void readFile(List<String> files) throws IOException {
        final Resource[] resources = context.getResources("classpath*:text/*");
        final Set<String> filePaths = findInputFileNames(resources);
        filePaths.forEach(str -> {
                log.info(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResource(str).getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                log.info(String.valueOf(stringBuilder));
            } catch (IOException e) {
                log.error(String.valueOf(e));
            }
        });
    }

    private Set<String> findInputFileNames(Resource[] resources) {
        return Arrays.stream(resources)
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

