package com.zhc.thread;

public class MyObject {
	private MyObject() {
	}

	private static class MyObjectHandler {
		private static MyObject myObject = new MyObject();
	}

	public static MyObject getInstance() {
		return MyObjectHandler.myObject;
	}
}
