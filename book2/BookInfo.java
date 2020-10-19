package book2;

import java.util.Scanner;

public class BookInfo extends Book implements Information {
	String writer;
	String location;
	String day;
	
	static int cnt;
	BookInfo() {

	}

	@Override
	public boolean input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("도서번호 입력 => ");
		bookNo = scan.next();
		System.out.print("도서명 입력=> ");
		title = scan.next();
		System.out.print("도서저자 입력=> ");
		writer = scan.next();
		System.out.print("도서위치 입력=> ");
		location = scan.next();
		
		 
		System.out.print("대출여부 입력 (y/n) => ");
		borrow = scan.next();
		if (borrow.toLowerCase().equals("n"))  
			return true;
		System.out.print("대출일자 입력 => ");
		day = scan.next();
		System.out.print("대출자 입력 => ");
		name = scan.next();
		System.out.println();
		return false;

	}

	public void process() {

	}

	@Override
	public void output() {
		System.out.printf("%4s      %3s     %4s       %3s      %3s      %7s    %3s\n", 
				bookNo, title, writer, location, borrow, day,  name);
	}

}
