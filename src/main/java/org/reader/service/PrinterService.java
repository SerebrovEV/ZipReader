package org.reader.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrinterService {

    private final ReaderService readerService;

    public void printFileName() throws IOException {
        List<String> files = new ArrayList<>();
        readerService.readFile(files);
        for (String str : files) {
            System.out.println(str);
        }
    }

    public void printTime() throws InterruptedException {
        String timeColonPattern = "dd-MM-YYYY HH:mm:ss";
        while (true) {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeColonPattern)));
            Thread.sleep(1000);
        }
    }
}
