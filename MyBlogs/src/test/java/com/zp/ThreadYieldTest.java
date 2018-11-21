package com.zp;

/**
 * 引用公众号： Java技术栈
 * url:https://mp.weixin.qq.com/s/INwudC6IWFj0mKmqqU_eJg
 * 多线程 Thread.yield 方法
 */

public class ThreadYieldTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-------------" + i);
                if (i % 20 == 0) {
                    Thread.yield();
                }
            }

        };
/*        new Thread(runnable, "栈长").start();
        new Thread(runnable, "小密").start();*/
        Thread thread1 = new Thread(runnable, "栈长");
        Thread thread2 = new Thread(runnable, "小密");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread2.start();
        thread1.start();


    }
}
