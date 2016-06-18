package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zwshao on 6/18/16.
 */
public class ProxyApp1 {

    public static void main(String[] args) {
        List<Integer> arraylistProxy = (List<Integer>) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(), new InvocationHandler() {
            private ArrayList<Integer> target = new ArrayList<Integer>();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long beginTime = System.currentTimeMillis();
                TimeUnit.MICROSECONDS.sleep(1);
                Object object = method.invoke(target, args);
                long endTime = System.currentTimeMillis();
                System.out.println("[" + method.getName() + "] spend " + (endTime - beginTime) + "ms");
                return object;
            }
        });

        arraylistProxy.add(2);
        arraylistProxy.add(4);
        for(int i : arraylistProxy){
            System.out.println(i);
        }
    }
}
