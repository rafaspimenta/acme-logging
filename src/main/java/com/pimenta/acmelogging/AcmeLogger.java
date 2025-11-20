package com.pimenta.acmelogging;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class AcmeLogger {
    private LogLevel logLevel = LogLevel.INFO;

    public void debug(String message) {
        if (isEnabled(LogLevel.DEBUG)) {
            log.debug(format(message));
        }
    }

    public void info(String message) {
        if (isEnabled(LogLevel.INFO)) {
            log.info(format(message));
        }
    }

    public void warn(String message) {
        if (isEnabled(LogLevel.WARN)) {
            log.warn(format(message));
        }
    }

    public void error(String message) {
        log.error(format(message));
    }

    private String format(String message) {
        return "[ACME]" + message;
    }

    private boolean isEnabled(LogLevel checklogLevel) {
        return switch (logLevel) {
            case DEBUG -> true;
            case INFO -> !checklogLevel.equals(LogLevel.DEBUG);
            case WARN -> checklogLevel.equals(LogLevel.WARN) || checklogLevel.equals(LogLevel.ERROR);
            case ERROR -> checklogLevel.equals(LogLevel.ERROR);
        };
    }
}
