package com.gofdemo.proxypattern_cglib;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    public static Object createProxy(Object target) {
        CglibInterceptor interceptor = new CglibInterceptor(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);
        enhancer.setUseCache(true);
        return enhancer.create();
    }
}
