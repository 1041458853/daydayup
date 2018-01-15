package com.itdragon.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ITDragonQueue {
	
	/**
	 * ArrayBlockingQueue : �����������������ʵ�֣����ڲ�ά����һ���������飬�Ա㻺������е����ݶ���
	 * �ڲ�û��ʵ�ֶ�д���룬���������Ѳ�����ȫ���У�
	 * ��������Ҫ����ģ�
	 * ����ָ���Ƚ��ȳ������Ƚ������
	 * ��һ���н���С�
	 * @throws Exception
	 */
	@Test
	public void ITDragonArrayBlockingQueue() throws Exception {  
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5); // ���Գ��� ���г�����3�ĵ�5  
        array.offer("offer �������ݷ���---�ɹ�����true ���򷵻�false");  
        array.offer("offer 3���������ݷ���", 3, TimeUnit.SECONDS);  
        array.put("put �������ݷ���---���������г����������ȴ���û�з���ֵ");  
        array.add("add �������ݷ���---���������г�������ʾ java.lang.IllegalStateException"); //  java.lang.IllegalStateException: Queue full  
        System.out.println(array);
        System.out.println(array.take() + " \t��ʣԪ�� : " + array);   // ��ͷ��ȡ��Ԫ�أ����Ӷ�����ɾ����������Ϊnull��һֱ�ȴ�
        System.out.println(array.poll() + " \t��ʣԪ�� : " + array);   // ��ͷ��ȡ��Ԫ�أ����Ӷ�����ɾ����ִ��poll �� Ԫ�ؼ���һ��
        System.out.println(array.peek() + " \t��ʣԪ�� : " + array);   // ��ͷ��ȡ��Ԫ�أ�ִ��peek ���Ƴ�Ԫ��
    }
	
	@Test
	public void ITDragonLinkedBlockingQueue() throws Exception {
		
	}

}
