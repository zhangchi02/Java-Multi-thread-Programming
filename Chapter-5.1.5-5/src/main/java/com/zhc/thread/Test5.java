package com.zhc.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5 {

	static class MyTask extends TimerTask {
		@Override
		public void run() {
			try {
				System.out.println("begin time = " + System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("  end time = " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Calendar calendar = Calendar.getInstance();
		Date runDate = calendar.getTime();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, runDate, 3000);
	}

}
