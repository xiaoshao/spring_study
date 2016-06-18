package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zwshao on 6/18/16.
 */
public class MyInvocationProxyHandler implements InvocationHandler {

    MyInterface target;

    public MyInvocationProxyHandler() {
        this.target = new MyObject();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
