package com.kozak.study.logging.impl;

import com.kozak.study.logging.ILogger;

public class ConsoleLogger implements ILogger {
    public void log(Object input) {
        System.out.println(input.toString());
    }
}
