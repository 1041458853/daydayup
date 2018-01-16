package com.itdragon.keyword;

import org.junit.Test;

public class ITDragonKeyWord {
	
	private Integer count = 5;
	
	/**
	 * �����÷�
	 * synchronized��������������󼰷����ϼ���������������δ����Ϊ"������"��"�ٽ���"
	 * ������ synchronized �ؼ��֣�����߳�ͬʱ�޸����ݣ����ܳ��ֲ���ȷ��ֵ�����ִ�г��򼴿ɿ��������
	 * ��֮�������÷���������ÿ���߳�����ִ�С�
	 */
	private synchronized void methodLock() {
		System.out.println("count = " + count--);
	}
	
	@Test
	public void synchronizedMethodLock() {
		for(int i = 1; i <= 5; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					methodLock();
				}
			});
			thread.start();
		}
	}

}
