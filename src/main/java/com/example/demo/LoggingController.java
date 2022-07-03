package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    private static final Logger LOGGER = LogManager.getLogger(LoggingController.class);
    @RequestMapping("/")
    public String index(@RequestHeader("X-Api-Header") String param){
        LOGGER.info("Info msg: " + param);
        return "Hello, world!";
    }
}
