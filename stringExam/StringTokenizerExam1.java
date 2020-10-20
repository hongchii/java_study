package stringExam;

import java.util.StringTokenizer;

class StringTokenizerExam1 {
	public static void main(String args[]) {
		StringTokenizer stok = new StringTokenizer("사과 배 복숭아");
		while (stok.hasMoreTokens()) {
			String str = stok.nextToken();
			System.out.println(str);
		}
	}
}