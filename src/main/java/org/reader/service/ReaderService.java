package org.reader.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ReaderService {

//    private final InputFile inputFile;

    private final ApplicationContext context;

    public ReaderService(ApplicationContext context) {
        this.context = context;
    }

    public void readFile(List<String> files) throws IOException {
        File directory = context.getResource("text/").getFile();
        files.addAll(Arrays.asList(Objects.requireNonNull(directory.list())));
    }
}
