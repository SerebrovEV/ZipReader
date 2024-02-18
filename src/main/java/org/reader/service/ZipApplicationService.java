package org.reader.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZipApplicationService {

    private final PrinterService printerService;

    public void run() {

        try {
            printerService.printFileName();
            printerService.printTime();
        } catch (InterruptedException | IOException e) {
            log.warn(e.getMessage());
        }
    }
}
