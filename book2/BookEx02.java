package book2;

import java.util.Scanner;

public class BookEx02 {
	final static int MAX = 100;

	public static void main(String[] args) {

		BookInfo obj[] = new BookInfo[MAX];
		int i, obj_cnt = 0;
		int menu;

		Scanner scan = new Scanner(System.in);

		while (true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}
			switch (menu) {
			case 1:
				input_Book(obj);
				break;
			case 2:
				output_Book(obj);
				break;
			case 3:
				search_Book(obj);
				break;
			case 4:
				update_Book(obj);
				break;
			case 5:
				delete_Book(obj);
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!!!\n");
			}
		}

	}

	static void printMenu() {
		System.out.println("*** 도서관리 ***");
		System.out.println("1. 도서정보 입력");
		System.out.println("2. 도서정보 출력");
		System.out.println("3. 도서정보 조회");
		System.out.println("4. 도서정보 수정");
		System.out.println("5. 도서정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	static void input_Book(BookInfo obj[]) {

		obj[BookInfo.cnt] = new BookInfo();
		obj[BookInfo.cnt].input();
		for (int i = 0; i < BookInfo.cnt; i++) {
			if (obj[i].bookNo.equals(obj[BookInfo.cnt].bookNo)) {
				System.out.println("\n도서정보 입력 오류(중복)!!\n");
				return;
			}
		}
		BookInfo.cnt++;
		System.out.println("\n도서정보 입력 성공!!\n");

	}

	static void output_Book(BookInfo obj[]) {
		int i;
		obj[BookInfo.cnt] = new BookInfo();

		if (BookInfo.cnt == 0) {
			System.out.println("출력 할 도서정보가 없습니다!!\n");
			return;
		}

		System.out.println("                             *** 도서정보 ***");
		System.out.println("=====================================================================");
		System.out.println("도서번호    도서제목    도서저자     도서위치     대출여부     대출일자     대출자");
		System.out.println("=====================================================================");
		for (i = 0; i < BookInfo.cnt; i++) {
			obj[i].output();
			System.out.println("=====================================================================");

		}
		System.out.println("\n도서정보 출력 완료!!\n");
		return;

	}

	static void search_Book(BookInfo obj[]) {
		Scanner scan = new Scanner(System.in);
		int i;

		System.out.print("조회 할 도서번호 입력 => ");
		String bookNo = scan.next();

		for (i = 0; i < BookInfo.cnt; i++) {
			if (obj[i].bookNo.equals(bookNo)) {
				System.out.println("\n                             *** 도서정보 ***");
				System.out.println("=====================================================================");
				System.out.println("도서번호    도서제목    도서저자     도서위치     대출여부     대출일자     대출자");
				System.out.println("=====================================================================");
				obj[i].output();;
				System.out.println("=====================================================================\n");
				return;
			}
		}
		System.out.println("\n조회 할 도서번호 입력 오류!!\n");
	}

	static void update_Book(BookInfo obj[]) {
		Scanner scan = new Scanner(System.in);
		int i;

		System.out.print("수정 할 도서번호 입력 => ");
		String bookNo = scan.next();

		for (i = 0; i < BookInfo.cnt; i++) {
			if (obj[i].bookNo.equals(bookNo)) {
				System.out.print("도서제목 입력 => ");
				obj[i].title = scan.next();
				System.out.print("대출여부 입력 (y/n) => ");
				obj[i].borrow = scan.next();
				if (obj[i].borrow.toLowerCase().equals("y")) {
					System.out.print("대출일자 입력 => ");
					obj[i].day = scan.next();
					System.out.print("대출자 입력 => ");
					obj[i].name = scan.next();
				} else
					obj[i].name = null;
					obj[i].day = null;
				System.out.println();
				System.out.println("\n도서정보 수정 성공!!\n");
				return;
			}
		}
		System.out.println("\n수정 할 도서번호 입력 오류!!\n");
	}

	static void delete_Book(BookInfo obj[]) {
		Scanner scan = new Scanner(System.in);
		int i, j;

		System.out.print("삭제 할 도서번호 입력 => ");
		String bookNo = scan.next();

		for (i = 0; i < BookInfo.cnt; i++) {
			if (obj[i].bookNo.equals(bookNo)) {

				for (j = i; j < BookInfo.cnt - 1; j++) {
					obj[j] = obj[j + 1];
				}
				BookInfo.cnt--;
				System.out.println("\n도서정보 삭제 성공!!\n");
				return;
			}
		}
		System.out.println("\n삭제 할 도서번호 입력 오류!!\n");
	}
}

//}
