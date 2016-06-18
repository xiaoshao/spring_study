package com.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by zwshao on 6/18/16.
 */
public class ProxyApp2 {

    public static void main(String[] args) {
        MyInterface proxyObject = (MyInterface)Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class<?>[]{MyInterface.class}, new MyInvocationProxyHandler());
        System.out.println(proxyObject.getResult());
    }
}
