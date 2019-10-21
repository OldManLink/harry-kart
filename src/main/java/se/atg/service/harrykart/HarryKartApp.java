package se.atg.service.harrykart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HarryKartApp {
    private final static Logger logger = LoggerFactory.getLogger(HarryKartApp.class);
    public static void main(final String ... args) {
        logger.info("Starting HarryKartApp application with args \"{}\"", new Object[]{args});
        SpringApplication.run(HarryKartApp.class, args);
    }
}
