package com.javaBasics;

public class JavaVariable {
	static int a = 500;// static variable

	int b = 50;// instant variable should be outside of method and accessible to inside of the
				// class only.

	public void Method1() {

		int c = 100;
		System.out.println("value of c=" + c);

	}

	static void Method2() { //static method

		int d = 100;
		System.out.println("value of d=" + d);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaVariable var = new JavaVariable();
		System.out.println(JavaVariable.a);//fetch val from static variable
		System.out.println(var.b);
		var.Method1();
		JavaVariable.Method2();//calling static method by using class name
		

	}

}
