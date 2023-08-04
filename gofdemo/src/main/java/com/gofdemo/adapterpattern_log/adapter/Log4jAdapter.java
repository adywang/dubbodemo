package com.gofdemo.adapterpattern_log.adapter;

import com.gofdemo.adapterpattern_log.ILogger;
import com.gofdemo.adapterpattern_log.Log4jLogger;

public class Log4jAdapter implements ILogger {
    private Log4jLogger log4jLogger;

    public Log4jAdapter(Log4jLogger log4jLogger) {
        this.log4jLogger = log4jLogger;
    }

    @Override
    public void info(String msg) {
        log4jLogger.Log(2, msg, null);
    }

    @Override
    public void warn(String msg, Exception exception) {
        log4jLogger.Log(3, msg, exception);
    }

    @Override
    public void debug(String msg) {
        log4jLogger.Log(1, msg, null);
    }

    @Override
    public void error(String msg, Exception exception) {
        log4jLogger.Log(4, msg, exception);
    }
}
