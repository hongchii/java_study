package stringExam;

public class StringExample03 {

	public static void main(String[] args) {
		String str1 = new String("자바");
		String str2 = new String("자바");
		if (str1.equals(str2))
			// str1 == str2 사용하면 객체의 주소가 비교됨. 문자열 값 비교시엔 equals 사용.
			System.out.println("같음");
		else
			System.out.println("다름");
	}

}
