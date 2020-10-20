package sungjuk_GUI;

import java.util.Scanner;

public class Sungjuk {
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;

	Sungjuk() {

	}
	// 생성자 추가, 키보드로 입력받기때문에 파라메타를 입력할필요없음.

	boolean input() {

		Scanner scan = new Scanner(System.in);
		System.out.print("학번을 입력 하세요 => ");
		this.hakbun = scan.next();
		System.out.print("이름을 입력 하세요 => ");
		this.irum = scan.next();
		System.out.print("국어점수를 입력 하세요 => ");
		this.kor = scan.nextInt();
		System.out.print("영어점수를 입력 하세요 => ");
		this.eng = scan.nextInt();
		System.out.print("수학점수를 입력 하세요 => ");
		this.math = scan.nextInt();
		return false;

	}

	void process() {
		tot = 0;
		avg = 0.0;
		tot = kor + eng + math;
		avg = tot / 3.;

		switch ((int) (this.avg / 10)) {
		case 10:
		case 9:
			this.grade = "수";
			break;
		case 8:
			this.grade = "우";
			break;
		case 7:
			this.grade = "미";
			break;
		case 6:
			this.grade = "양";
			break;
		default:
			this.grade = "가";
		}
	}

	void output() {

		System.out.printf("%2s  %3s   %3d  %3d   %3d   %3d  %5.2f %2s\n", hakbun, irum, kor, eng, math, tot, avg,
				grade);
	}

}
