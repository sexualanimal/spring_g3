package com.kozak.study.logging.impl;

public class ServerStartFinishConsoleLogger extends ConsoleLogger {
    private void started() {
        log("start");
    }

    private void stopped() {
        log("stop");
    }
}
