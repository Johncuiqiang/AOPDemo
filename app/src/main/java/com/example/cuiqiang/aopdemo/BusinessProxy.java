package com.example.cuiqiang.aopdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author : cuiqiang
 * @DATE : 2018/12/14 14:17
 * @Description :
 */
public class BusinessProxy {

    //成员变量
    private Object target;//被代理的对象

    //使用有参数的构造方法设置代理对象
    public BusinessProxy(Object target) {
        this.target = target;
    }


    public Object getObjectProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //方法执行前
                        String params = "修改了";
                        Object result = method.invoke(target, params);
                        //方法执行后
                        return result;
                    }
                });
    }

}
