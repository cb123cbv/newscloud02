package com.jk.test;

public class MyThread extends Thread {

private int i=0;

 public void run(){
     for (int i = 0; i<100; i++) {
         System.out.println(Thread.currentThread().getName()+""+i);
     }
 }


}
