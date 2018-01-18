package com.itdragon.keyword;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile �ؼ�����Ҫ���þ���ʹ�����ڶ���߳��пɼ�
 *
 */
public class ITDragonVolatile implements Runnable{
	
    private volatile boolean flag = true;  
    private static volatile int count;   
    private static AtomicInteger atomicCount = new AtomicInteger(0); // ����������ϵ����  
    
    @Override  
    public void run() {  
//    	volatileMethod();
    	volatileAndAtomicMethod();
    }  
    
    private void volatileMethod() {
    	System.out.println("thread start !");  
        while (flag) {  // ���flagΪtrue��һֱ���������У�
        }  
        System.out.println("thread end !");
    }
    
    private synchronized void volatileAndAtomicMethod() {
    	for (int i = 0; i < 1000; i++) {  
        	count++ ;  
        	atomicCount.incrementAndGet();  
        }  
        System.out.println("count : " + count);
        System.out.println("atomicCount : " + atomicCount);
    }
  
    /**
     * �����
     * �����������̣߳�һ����main�����̣߳�һ����thread�����߳�
     * 
     * 
     */
    public static void main(String[] args) throws InterruptedException {  
//    	ITDragonVolatile itDragonVolatile = new ITDragonVolatile();  
//    	Thread thread = new Thread(itDragonVolatile);
//    	thread.start();
//    	Thread.sleep(1000);  // ���߳������ˣ�������ֵ
//    	itDragonVolatile.setFlag(false);  
//    	System.out.println("flag : " + itDragonVolatile.isFlag());  
    	for (int i = 0; i < 10; i++) {
    		new Thread(new ITDragonVolatile()).start();
		}
    }  
      
    public boolean isFlag() {  
        return flag;  
    }  
  
    public void setFlag(boolean flag) {  
        this.flag = flag;  
    }  

}
