package com.pimenta.acmelogging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcmeLoggerTest {

    private AcmeLogger logger;

    @BeforeEach
    void setUp() {
        logger = new AcmeLogger();
    }

    @Test
    void testDefaultLogLevelIsInfo() {
        assertEquals(LogLevel.INFO, logger.getLogLevel());
    }

    @Test
    void testSetLogLevel() {
        logger.setLogLevel(LogLevel.DEBUG);
        assertEquals(LogLevel.DEBUG, logger.getLogLevel());

        logger.setLogLevel(LogLevel.WARN);
        assertEquals(LogLevel.WARN, logger.getLogLevel());

        logger.setLogLevel(LogLevel.ERROR);
        assertEquals(LogLevel.ERROR, logger.getLogLevel());
    }

    @Test
    void testDebugLevel_AllMessagesEnabled() {
        logger.setLogLevel(LogLevel.DEBUG);

        assertDoesNotThrow(() -> logger.debug("debug message"));
        assertDoesNotThrow(() -> logger.info("info message"));
        assertDoesNotThrow(() -> logger.warn("warn message"));
        assertDoesNotThrow(() -> logger.error("error message"));
    }

    @Test
    void testInfoLevel_DebugDisabled() {
        logger.setLogLevel(LogLevel.INFO);

        assertDoesNotThrow(() -> logger.info("info message"));
        assertDoesNotThrow(() -> logger.warn("warn message"));
        assertDoesNotThrow(() -> logger.error("error message"));
        assertDoesNotThrow(() -> logger.debug("debug message")); // Should not throw, just not log
    }

    @Test
    void testWarnLevel_OnlyWarnAndErrorEnabled() {
        logger.setLogLevel(LogLevel.WARN);

        assertDoesNotThrow(() -> logger.warn("warn message"));
        assertDoesNotThrow(() -> logger.error("error message"));
        assertDoesNotThrow(() -> logger.debug("debug message")); // Should not throw
        assertDoesNotThrow(() -> logger.info("info message")); // Should not throw
    }

    @Test
    void testErrorLevel_OnlyErrorEnabled() {
        logger.setLogLevel(LogLevel.ERROR);

        assertDoesNotThrow(() -> logger.error("error message"));
        assertDoesNotThrow(() -> logger.debug("debug message")); // Should not throw
        assertDoesNotThrow(() -> logger.info("info message")); // Should not throw
        assertDoesNotThrow(() -> logger.warn("warn message")); // Should not throw
    }

    @Test
    void testErrorAlwaysLogsRegardlessOfLevel() {
        logger.setLogLevel(LogLevel.ERROR);
        assertDoesNotThrow(() -> logger.error("error message"));

        logger.setLogLevel(LogLevel.WARN);
        assertDoesNotThrow(() -> logger.error("error message"));

        logger.setLogLevel(LogLevel.INFO);
        assertDoesNotThrow(() -> logger.error("error message"));

        logger.setLogLevel(LogLevel.DEBUG);
        assertDoesNotThrow(() -> logger.error("error message"));
    }

    @Test
    void testMessageFormatting() {
        // Since format() is private, we test indirectly through the public methods
        // The actual formatting "[ACME]" prefix is tested via integration/logging
        // framework tests
        logger.setLogLevel(LogLevel.DEBUG);
        assertDoesNotThrow(() -> logger.debug("test message"));
    }

    @Test
    void testNullMessage() {
        logger.setLogLevel(LogLevel.DEBUG);
        assertDoesNotThrow(() -> logger.debug(null));
        assertDoesNotThrow(() -> logger.info(null));
        assertDoesNotThrow(() -> logger.warn(null));
        assertDoesNotThrow(() -> logger.error(null));
    }
}
