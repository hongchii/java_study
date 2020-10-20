package sungjuk2;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukInner {
	private ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();

	void addSungjuk(Sungjuk obj) {
		list.add(obj);
		
		System.out.println("성적정보 입력 성공!!\n");
	}                

	/*
	 * void addSungjuk() { 
	 * Sungjuk obj = new Sungjuk(); 
	 * obj.input(); 
	 * if (checkSungjuk(obj)) { 
	 * System.out.println("\n학번 입력 오류 (중복)!!\n"); 
	 * return; 
	 * }
	 * obj.process(); 
	 * list.add(obj); 
	 * System.out.println("성적정보 입력 성공!!\n"); }
	 */

	public ArrayList<Sungjuk> getList() {
		return list;
	} // ArrayList<Sungjuk>을 private로 적어줘서 다른 곳에서 접근 가능하도록 적어준 메소드.
	

	void removeSungjuk(Sungjuk obj) {
		list.remove(obj);
	}

	int getSungjukNum() {
		return list.size();
	}

	Sungjuk getSungjuk(int index) {
		return list.get(index);
	}

	double getTotalAvg() {
		double tot_avg = 0;
		for (Sungjuk obj : list)
			tot_avg += obj.avg;
		return tot_avg;
	}

	boolean checkSungjuk(Sungjuk obj) {
		for (Sungjuk dat : list) {
			if (dat.hakbun.equals(obj.hakbun)) {
				return true;
			}
		}
		return false;
	}

	class Sungjuk {
		String hakbun, irum;
		int kor, eng, math, tot;
		double avg;
		String grade;

		public Sungjuk() {

		}

		void input() {
			Scanner scan = new Scanner(System.in);

			System.out.print("학번 입력 => ");
			hakbun = scan.next();
			System.out.print("이름 입력 => ");
			irum = scan.next();
			System.out.println("국어 입력 => ");
			kor = scan.nextInt();
			System.out.println("영어 입력 => ");
			eng = scan.nextInt();
			System.out.println("수학 입력 => ");
			math = scan.nextInt();
		}

		void process() {
			tot = kor + eng + math;
			avg = tot / 3.;

			switch ((int) (this.avg / 10)) {
			case 10:
			case 9:
				grade = "수";
				break;
			case 8:
				grade = "우";
				break;
			case 7:
				grade = "미";
				break;
			case 6:
				grade = "양";
				break;
			default:
				grade = "가";
				break;
			}
		}

		void output() {
			System.out.printf("%4s %3s  %3d  %3d   %3d %3d %6.2f %2s\n", hakbun, irum, kor, eng, math, tot, avg, grade);
		}
	}
}
