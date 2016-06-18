package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwshao on 6/18/16.
 */
public class ProxyUtil {

    public enum ArrayListProxy {
        PROXY;

        private Object target;

        ArrayListProxy() {
            this.target = new ArrayList();
        }

        public List getInstance() {
            return (List)Proxy.newProxyInstance(ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(), new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(target, args);
                }
            });
        }
    }
}
