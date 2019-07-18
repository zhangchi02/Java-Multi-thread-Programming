package com.zhc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();
	public Condition conditionA = lock.newCondition();
	public Condition conditionB = lock.newCondition();
	public void awaitA() {
		try {
			lock.lock();
			System.out.println("begin awaitA time=" + System.currentTimeMillis() + " ThreadName="
					+ Thread.currentThread().getName());
			conditionA.await();
			System.out.println("  end awaitA time=" + System.currentTimeMillis() + " ThreadName="
					+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void awaitB() {
		try {
			lock.lock();
			System.out.println("begin awaitB time=" + System.currentTimeMillis() + " ThreadName="
					+ Thread.currentThread().getName());
			conditionB.await();
			System.out.println("  end awaitB time=" + System.currentTimeMillis() + " ThreadName="
					+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll_A() {
		try {
			lock.lock();
			System.out.println(
					" signalAll_A time=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
			conditionA.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll_B() {
		try {
			lock.lock();
			System.out.println(
					" signalAll_B time=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
			conditionB.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
