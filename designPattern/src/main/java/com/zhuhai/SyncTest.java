package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/2/27
 * Time: 22:14
 *
 * @author: hai
 */
public class SyncTest implements Runnable {

    static SyncTest instance = new SyncTest();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
        //method1();

    }


    public synchronized static void method1() {
        //synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1运行完毕");
        //}
    }

    public synchronized void method2() {
        //synchronized (SyncTest.class) {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method2运行完毕");
        //}
    }


    public static void main(String[] args) throws InterruptedException {
        SyncTest instance1 = new SyncTest();
        SyncTest instance2 = new SyncTest();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.join();
        thread2.join();
        thread1.start();
        thread2.start();

    }

}
