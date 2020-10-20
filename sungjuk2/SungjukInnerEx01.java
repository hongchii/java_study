package sungjuk2;

import java.util.Scanner;

public class SungjukInnerEx01 {

	public static void main(String[] args) {
		SungjukInner sungjuk = new SungjukInner();
		int menu;

		Scanner scan = new Scanner(System.in);

		while (true) {
			printMenu();
			System.out.println("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			switch (menu) {
			case 1:
			input_sungjuk(sungjuk);
				break;
			case 2:
				output_sungjuk(sungjuk);
				break;
			case 3:
				search_sungjuk(sungjuk);
				break;
			case 4:
				update_sungjuk(sungjuk);
				break;
			case 5:
				delete_sungjuk(sungjuk);
				break;
			default:

			}

		}
	}

	static void printMenu() {
		System.out.println("*** 성적관리 ***");
		System.out.println("1. 성적정보 입력");
		System.out.println("2. 성적정보 출력");
		System.out.println("3. 성적정보 조회");
		System.out.println("4. 성적정보 수정");
		System.out.println("5. 성적정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();

	}

	static void input_sungjuk(SungjukInner sungjuk) {
		SungjukInner.Sungjuk obj = sungjuk.new Sungjuk();
		obj.input();
		if (sungjuk.checkSungjuk(obj)) {
			System.out.println("\n학번 입력 오류 (중복)!!\n");
			return;
		}
		obj.process();
		sungjuk.addSungjuk(obj);
		System.out.println("성적정보 입력 성공!!\n");
	}

	/*
	 * static void input_sungjuk(SungjukInner sungjuk) { sungjuk.addSungjuk(); }
	 */

	static void output_sungjuk(SungjukInner sungjuk) {
		if (sungjuk.getSungjukNum() == 0) {
			System.out.println("출력할 성적정보가 없습니다!!\n");
			return;
		}

		System.out.println("\n              *** 성적표 ***");
		System.out.println("=============================================");
		System.out.println("학번   이름   국어   영어   수학   총점   평균   등급");
		System.out.println("=============================================");
		for (SungjukInner.Sungjuk dat : sungjuk.getList()) {
			dat.output();
		}
		System.out.println("=============================================");
		System.out.printf("\t 총학생수 : %d, 전체평균 : %5.2f\n\n", sungjuk.getSungjukNum(),
				sungjuk.getTotalAvg() / sungjuk.getSungjukNum());

	}

	static void search_sungjuk(SungjukInner sungjuk) {
		Scanner scan = new Scanner(System.in);

		System.out.println("조회할 학번 입력 => ");
		String hakbun = scan.next();

		for (SungjukInner.Sungjuk dat : sungjuk.getList()) {
			if (hakbun.contentEquals(dat.hakbun)) {
				System.out.println("\n학번   이름   국어   영어   수학   총점   평균   등급");
				System.out.println("=============================================");
				dat.output();
				System.out.println("=============================================");
				return;
			}
		}
		System.out.println("\n조회할 학번 입력 오류!!\n");
	}

	static void update_sungjuk(SungjukInner sungjuk) {
		Scanner scan = new Scanner(System.in);

		System.out.println("수정할 학번 입력 => ");
		String hakbun = scan.next();

		for (SungjukInner.Sungjuk dat : sungjuk.getList()) {
			if (hakbun.equals(dat.hakbun)) {
				System.out.println("국어 입력 => ");
				dat.kor = scan.nextInt();
				System.out.println("영어 입력 => ");
				dat.eng = scan.nextInt();
				System.out.println("수학 입력 => ");
				dat.math = scan.nextInt();
			}
		}
		System.out.println("\n수정할 학번 입력 오류!!\n");
	}

	static void delete_sungjuk(SungjukInner sungjuk) {
		Scanner scan = new Scanner(System.in);

		System.out.println("삭제할 학번 입력 => ");
		String hakbun = scan.next();

		for (SungjukInner.Sungjuk dat : sungjuk.getList()) {
			if (hakbun.equals(dat.hakbun)) {
				sungjuk.removeSungjuk(dat);
				System.out.println("\n성적정보 삭제 성공!!\n");
				return;
			}
		}
		System.out.println("\n삭제할 학번 입력 오류!!\n");
	}
}
