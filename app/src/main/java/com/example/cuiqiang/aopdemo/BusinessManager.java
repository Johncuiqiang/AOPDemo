package com.example.cuiqiang.aopdemo;

import java.util.HashMap;

/**
 * @Author : cuiqiang
 * @DATE : 2018/12/14 13:43
 * @Description :
 */
public class BusinessManager {

    private static BusinessManager INSTANCE;
    private HashMap<String,Object> mBusinessMap;

    public static BusinessManager getInstance() {
        if (INSTANCE == null) {
            synchronized (BusinessManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BusinessManager();
                }
            }
        }
        return INSTANCE;
    }

    public void init() {
        mBusinessMap = new HashMap<>();
    }


    public void register(String className) {
        Object businessClass = null;
        try {
            Class aClass = Class.forName(className);
            businessClass = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        if (mBusinessMap != null) {
            mBusinessMap.put(className, businessClass);
        }
    }

    /**
     * 利用动态代理的模式去执行业务，扩展性更强
     * 算是AOP编程的一种实现
     * 强转类型必须是接口
     */
    public void show(String className) {
        Object businessListenerClass = mBusinessMap.get(className);
        if (businessListenerClass != null) {
            BusinessProxy proxy = new BusinessProxy(businessListenerClass);
            Object obj = proxy.getObjectProxy();
            BusinessListener businessListener = (BusinessListener) obj;
            if (businessListener != null){
                businessListener.show("ui");
                businessListener.click("event");
            }
        }
    }

    public Object getClass(String className){
       return mBusinessMap.get(className);
    }

}
