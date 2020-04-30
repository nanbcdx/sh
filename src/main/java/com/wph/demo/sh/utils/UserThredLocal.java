package com.wph.demo.sh.utils;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/24 23:53
 */
public class UserThredLocal {
    private static ThreadLocal threadLocal=new ThreadLocal();

    public static void set(Object obj){
        threadLocal.set(obj);
    }

    public static Object get(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }

}
