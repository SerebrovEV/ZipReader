package org.reader.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZipApplicationService {

    private final PrinterService printerService;

    public void run() {
        try {
            printerService.printTime();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
