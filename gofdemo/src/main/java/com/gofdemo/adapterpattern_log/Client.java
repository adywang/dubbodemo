package com.gofdemo.adapterpattern_log;

import com.gofdemo.adapterpattern_log.adapter.Log4jAdapter;
import com.gofdemo.adapterpattern_log.adapter.LogbackAdapter;

public class Client {
    public static void main(String[] args) {
        ILogger logger=new Log4jAdapter(new Log4jLogger());
        logger.info("测试log4j");
        logger=new LogbackAdapter(new LogBackLogger());
        logger.info("测试logback");
    }
}
