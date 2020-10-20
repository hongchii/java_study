package stringExam;

public class StringExample01 {

	public static void main(String[] args) {
		String str = "자바 커피";
		int len = str.length();	 // length 메서드 호출.
		//자바 커피 의 길이는 5 len에는 5가 저장.
		for (int cnt = 0; cnt < len; cnt++) {
			// cnt가 len (5) 보다 작을때까지 for문 돎.
			char ch = str.charAt(cnt);  // charAt 메서드 호출.
			System.out.println(ch);
			// ch에는 해당하는 문자열이 저장돼서 반환 됨. 자0바1 2커3피4
		}
	}

}
