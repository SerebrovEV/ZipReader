package org.reader.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class PrinterService {

    private final ReaderService readerService;

    public void printFileName() {

    }

    public void printTime() throws InterruptedException {
        String timeColonPattern = "dd-MM-YYYY HH:mm:ss";
        while (true) {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeColonPattern)));
            Thread.sleep(1000);
        }
    }
}
