package com.itdragon.keyword;

/**
 * synchronized �ؼ��֣��������η�����Ҳ�������δ���顣������ú��ߣ�ͨ����С�������ȣ������ϵͳ���ܡ�
 * synchronized �ؼ��֣�������ַ�����Ϊ������ע��String�����صĻ��湦�ܺ��ַ����ı�����Ƿ�������
 * synchronized �����룬
 * synchronized ͬ�첽��
 * synchronized ��������static + synchronized �������ʾ����������м���
 */
public class ITDragonSynchronized {
	
    private void thisLock () {  // ������  
        synchronized (this) {  
            System.out.println("this ������!");  
        }  
    }  
      
    private void classLock () {  // ����  
        synchronized (ITDragonSynchronized.class) {  
            System.out.println("class ����!");  
        }  
    }  
      
    private Object lock = new Object();  
    private void objectLock () {  // �κζ�����  
        synchronized (lock) {  
            System.out.println("object �κζ�����!");  
        }  
    }  
      
    private void stringLock () {  // �ַ�������ע��String�����صĻ��湦��  
        synchronized ("string") { // �� new String("string")  t4 �� t5 ͬʱ���롣��string t4��ɺ�t5�ڿ�ʼ
            try {  
                for(int i = 0; i < 3; i++) {  
                    System.out.println("thread : " + Thread.currentThread().getName() + " stringLock !");  
                    Thread.sleep(500);       
                }  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    private String strLock = "lock";  // �ַ������ı�  
    private void changeStrLock () {  
        synchronized (strLock) {  
            try {  
                System.out.println("thread : " + Thread.currentThread().getName() + " changeLock start !");  
                strLock = "changeLock";  
                Thread.sleep(500);  
                System.out.println("thread : " + Thread.currentThread().getName() + " changeLock end !");  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    private synchronized void method1() {  // ������
        System.out.println("^^^^^^^^^^^^^^^^^^^^ method1");  
        method2();  
    }  
    private synchronized void method2() {  
        System.out.println("-------------------- method2");  
        method3();  
    }  
    private synchronized void method3() {  
        System.out.println("******************** method3");  
    }  
    
    private synchronized void syncMethod() {  
        try {  
            System.out.println(Thread.currentThread().getName() + " synchronized method!");  
            Thread.sleep(2000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
      
    // ���η���Ҳ������ synchronized���ͱ���ȴ�t1�߳�ִ�����t2���ܵ���  ������synchronized��֮����л����ԣ�synchronized���õ���һ�������������仰˵��synchronized������������������
    private void asyncMethod() {  
        System.out.println(Thread.currentThread().getName() + " asynchronized method!");  
    } 
      
    // ������static + synchronized �������ʾ��������ӡ�Ľ���� thread1 �߳���ִ���꣬Ȼ����ִ��thread2�̡߳���û�б�static ���Σ���thread1 �� thread2 ����ͬʱִ�У�ͬʱ����
	private synchronized void classLock(String args) {
		System.out.println(args + "start......");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(args + "end......");
	}
	
    public static void main(String[] args) throws Exception {  
        final ITDragonSynchronized itDragonSynchronized = new ITDragonSynchronized();  
        System.out.println("------------------------- synchronized �������� -------------------------");
        Thread thread1 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.thisLock();  
            }  
        });  
        Thread thread2 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.classLock();  
            }  
        });  
        Thread thread3 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.objectLock();  
            }  
        });  
        thread1.start();  
        thread2.start();  
        thread3.start();  
        Thread.sleep(2000);
        System.out.println("------------------------- synchronized �ַ������� -------------------------");
        // ����ַ���������new String("string") t4��t5�߳��ǿ��Ի�ȡ���ģ����ֱ��ʹ��"string" ���������ͷţ�t5�߳�һֱ����ȴ���  
        Thread thread4 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.stringLock();  
            }  
        }, "t4");  
        Thread thread5 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.stringLock();  
            }  
        }, "t5");  
        thread4.start();  
        thread5.start();  
          
        Thread.sleep(3000);
        System.out.println("------------------------- synchronized �ַ������� -------------------------");
        // �ַ������ˣ���Ҳ��ı䣬����t7�߳���t6�߳�δ������俪ʼִ��,��һ����������Ա��ˣ���Ӱ��������������  
        Thread thread6 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.changeStrLock();  
            }  
        }, "t6");  
        Thread thread7 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.changeStrLock();  
            }  
        }, "t7");  
        thread6.start();  
        thread7.start(); 
        
        Thread.sleep(2000);
        System.out.println("------------------------- synchronized ������ -------------------------");
        Thread thread8 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.method1();  
            }  
        }, "t8");  
        thread8.start(); 
        Thread thread9 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                SunClass sunClass = new SunClass();  
                sunClass.sunMethod();  
            }  
        }, "t9");  
        thread9.start(); 
        
        Thread.sleep(2000);
        System.out.println("------------------------- synchronized ͬ���첽 -------------------------");
        Thread thread10 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                itDragonSynchronized.syncMethod();  
            }  
        }, "t10");  
        Thread thread11 = new Thread(new Runnable() {  
            @Override  
            public void run() {  
            	itDragonSynchronized.asyncMethod();  
            }  
        }, "t11");  
        thread10.start(); 
        thread11.start(); 
        
        Thread.sleep(2000);
        System.out.println("------------------------- synchronized ͬ���첽 -------------------------");
        ITDragonSynchronized classLock1 = new ITDragonSynchronized();
        ITDragonSynchronized classLock2 = new ITDragonSynchronized();
		Thread thread12 = new Thread(new Runnable() {
			@Override
			public void run() {
				classLock1.classLock("classLock1");
			}
		});
		thread12.start();
		Thread thread13 = new Thread(new Runnable() {
			@Override
			public void run() {
				classLock2.classLock("classLock2");
			}
		});
		thread13.start();
    }  
    
    // �и��Ӽ̳й�ϵ���࣬�����ʹ����synchronized �ؼ��֣�Ҳ���̰߳�ȫ�ġ�  
    static class FatherClass {  
        public synchronized void fatherMethod(){  
            System.out.println("#################### fatherMethod");  
        }  
    }  
      
    static class SunClass extends FatherClass{  
        public synchronized void sunMethod() {  
            System.out.println("@@@@@@@@@@@@@@@@@@@@ sunMethod");  
            this.fatherMethod();
        }  
    }  
}
