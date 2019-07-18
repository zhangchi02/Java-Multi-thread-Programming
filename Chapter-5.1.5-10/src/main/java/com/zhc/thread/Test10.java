package com.zhc.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test10 {

	static int i = 0;

	static class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("第 " + ++i + "次执行");
			System.out.println("begin time = " + new Date());
			System.out.println("  end time = " + new Date());
		}
	}

	public static void main(String[] args) {
		MyTask task = new MyTask();
		System.out.println("现在执行时间：" + new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
		Date runDate = calendar.getTime();
		System.out.println("计划执行时间： " + runDate);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, runDate, 2000);
	}

}
