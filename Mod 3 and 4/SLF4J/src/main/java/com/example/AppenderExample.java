package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message from AppenderExample");
        logger.info("Info message from AppenderExample");
        logger.warn("Warning message from AppenderExample");
        logger.error("Error message from AppenderExample");
    }
}
