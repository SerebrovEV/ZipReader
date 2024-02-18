//package org.reader.dao;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@Component
//public class InputFile {
//
//    private final ApplicationContext context;
//
//    private final String filePath;
//
//    public InputFile(ApplicationContext context, @Value("${path.file}") String filePath) {
//        this.context = context;
//        this.filePath = filePath;
//    }
//
//    public List<String> getFilesNames() throws IOException {
//        final List<String> result = new ArrayList<>();
//        File directory = context.getResource(filePath).getFile();
//        for (String str : directory.list()) {
//            log.info(str);
//            result.add(str);
//        }
//        return result;
//    }
//}
