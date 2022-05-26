package com.javaStatment;

public class elseifladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int percentage=40;
		System.out.println(" value of percantage :"+ percentage);
		int result=percentage;
		if(result >=90) {
			char grade='A';
			System.out.println("your performance is excellent");
			
			System.out.println("your garde is: "+ grade);
			
		}
		else if(result>=70){
			char grade='B';
			System.out.println("your performance is great");
			System.out.println("your garde is: "+ grade);
			
		}
		else if(result>=50) {
			char grade='C';
			System.out.println("your performance need to be improved");
			System.out.println("your garde is: "+ grade);
			
			

		}
		else {
			
			System.out.println("Sorry! you are failed in this exam");
		}

	}

}
