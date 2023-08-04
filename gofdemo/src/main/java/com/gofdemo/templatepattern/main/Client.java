package com.gofdemo.templatepattern.main;

import com.gofdemo.templatepattern.RegisteProcessor;
import com.gofdemo.templatepattern.RegisterTemplate;

public class Client {
    public static void main(String[] args) throws Exception {
        RegisterTemplate template=new RegisteProcessor();
        template.register("tom","190");
    }
}
