package com.javaStatment;

public class switch_statment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5,b=2,result;
		int choice=3;
		switch(choice) {
		case 0: 
			System.out.println("perform addition of a & b");
			result= a+b;
			System.out.println("the result is:" +result);
			break;
		case 1:
			System.out.println("perform substraction of a & b");
			result= a-b;
			System.out.println("the result is:" +result);
			break;
		case 2:
			System.out.println("perform multiplication of a & b");
			result= a*b;
			System.out.println("the result is:" +result);
			break;
		case 3:
			System.out.println("perform division of a & b");
			result= a/b;
			System.out.println("the result is:" +result);
			break;
		default:
			System.out.println("invalid choice");
			break;
			
			
		}
		

	}

}
