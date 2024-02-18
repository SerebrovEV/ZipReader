package org.reader;

import lombok.extern.slf4j.Slf4j;
import org.reader.service.ZipApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Slf4j
@SpringBootApplication
public class ZipReaderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ZipReaderApplication.class);
        ZipApplicationService service = context.getBean(ZipApplicationService.class);
        log.info("Service run");
        service.run();
        log.info("Service stop");
    }
}
