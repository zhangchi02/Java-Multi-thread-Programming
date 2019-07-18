package com.zhc.thread;

import java.io.Serializable;

public class MyObject implements Serializable{
	private static final long serialVersionUID = 2741397206141840558L;

	private MyObject() {
	}

	private static class MyObjectHandler {
		private static MyObject myObject = new MyObject();
	}

	public static MyObject getInstance() {
		return MyObjectHandler.myObject;
	}
	
	protected Object readResolve() {
		System.out.println("调用了readResolve方法！");
		return MyObjectHandler.myObject;
	}
}
