package com.gofdemo.adapterpattern_log;

public class Log4jLogger {

    public void Log(int level, String msg,Exception exception) {
        System.out.println("log4j " + level + ":" + msg);
        if(exception!=null){
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
    }
}
