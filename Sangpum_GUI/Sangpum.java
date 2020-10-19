package Sangpum_GUI;

import java.util.Scanner;

public class Sangpum {
	String code, irum, grade;
	int su, dan, price;
	
	Sangpum() {
	}

	boolean input_sangpum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		if (code.equals("exit"))
			return true;
		System.out.print("상품명 입력 => ");
		irum = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		return false;
	}

	void process_sangpum() {
		price = su * dan;

		if (su >= 100)
			grade = "우수";
		else if (su >= 70)
			grade = "보통";
		else
			grade = "분발";
	}

	void output_sangpum() {
		System.out.printf("%4s  %6s     %4d  %7d %8d   %2s\n", code, irum, su, dan, price, grade);
	}
	
}
