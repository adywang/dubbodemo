package com.gofdemo.adapterpattern_log;

//目标接口
public interface ILogger {
    void info(String msg);

    void warn(String msg, Exception exception);

    void debug(String msg);

    void error(String msg, Exception exception);
}
