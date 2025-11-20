package com.pimenta.acmelogging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogLevelTest {

    @Test
    void testLogLevelEnumValues() {
        LogLevel[] levels = LogLevel.values();
        
        assertEquals(4, levels.length);
        assertTrue(contains(levels, LogLevel.DEBUG));
        assertTrue(contains(levels, LogLevel.INFO));
        assertTrue(contains(levels, LogLevel.WARN));
        assertTrue(contains(levels, LogLevel.ERROR));
    }

    @Test
    void testLogLevelValueOf() {
        assertEquals(LogLevel.DEBUG, LogLevel.valueOf("DEBUG"));
        assertEquals(LogLevel.INFO, LogLevel.valueOf("INFO"));
        assertEquals(LogLevel.WARN, LogLevel.valueOf("WARN"));
        assertEquals(LogLevel.ERROR, LogLevel.valueOf("ERROR"));
    }

    @Test
    void testLogLevelValueOf_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            LogLevel.valueOf("INVALID");
        });
    }

    private boolean contains(LogLevel[] levels, LogLevel level) {
        for (LogLevel l : levels) {
            if (l == level) {
                return true;
            }
        }
        return false;
    }
}

