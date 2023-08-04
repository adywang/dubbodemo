package com.gofdemo.adapterpattern_log;

//被代理的logback
public class LogBackLogger {
    public void LogInfo(String msg, Exception ex) {
        System.out.println("logback info:" + msg);
        if (null != ex) {
            ex.printStackTrace();
        }

    }

    public void LogDebug(String msg) {
        System.out.println("logback debug:" + msg);
    }


    public void LogError(String msg, Exception ex) {
        System.out.println("logback debug:" + msg);
        if (null != ex) {
            ex.printStackTrace();
        }

    }

    public void LogWarn(String msg, Exception ex) {
        System.out.println("logback debug:" + msg);
        if (null != ex) {
            ex.printStackTrace();
        }

    }


}
