package com.gofdemo.adapterpattern_log.adapter;

import com.gofdemo.adapterpattern_log.ILogger;
import com.gofdemo.adapterpattern_log.LogBackLogger;

public class LogbackAdapter implements ILogger {
    public LogbackAdapter(LogBackLogger logBackLogger) {
        this.logBackLogger = logBackLogger;
    }

    private LogBackLogger logBackLogger;

    @Override
    public void info(String msg) {
        logBackLogger.LogInfo(msg, null);
    }

    @Override
    public void warn(String msg, Exception exception) {
        logBackLogger.LogWarn(msg, exception);
    }

    @Override
    public void debug(String msg) {
        logBackLogger.LogDebug(msg);
    }

    @Override
    public void error(String msg, Exception exception) {
        logBackLogger.LogError(msg, exception);
    }
}
