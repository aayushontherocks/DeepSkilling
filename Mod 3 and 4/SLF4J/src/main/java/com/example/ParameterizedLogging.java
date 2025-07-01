package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String item = "SSD";
        int quantity = 5;
        double price = 7999.99;

        logger.info("User ordered {} units of {} at ₹{}", quantity, item, price);
        logger.debug("Debug: Quantity = {}, Item = {}, Price = {}", quantity, item, price);
        logger.warn("Stock running low for item: {}", item);
        logger.error("Failed to update inventory for item: {}", item);
    }
}
