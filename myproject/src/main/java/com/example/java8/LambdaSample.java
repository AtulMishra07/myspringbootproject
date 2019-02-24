package com.example.java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.DoubleFunction;

public class LambdaSample {

	public static void main(String[] args) {
		Calculator calc = (int a, int b) -> a+b;
		int res = calc.add(5, 6);
		System.out.println(res);
		
		DoubleFunction<String> ob = f -> String.valueOf(f*3);
	       
		 System.out.println(ob.apply(20.3));
		 
		 LocalDate start = LocalDate.now();
			System.out.println("Period.between:"+Period.between(start, LocalDate.MAX).getDays());
			System.out.println("Period.ofDays:"+Period.ofDays(5).getDays());
		for(int i = 0 ; i<100;i++) {
			if(i%15==0) {
				System.out.println("Divided by 3 & 5 " +i);
			}
			if(i%3==0) {
				System.out.println("Divided by 3 " +i);
			}
			if(i%5==0) {
				System.out.println("Divided by 5 " +i);
			}
		}
	}

}
