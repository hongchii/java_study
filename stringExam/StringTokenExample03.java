package stringExam;

import java.util.*;
import java.util.StringTokenizer;

public class StringTokenExample03 {

	public static void main(String[] args) {

		LinkedList<Integer> numList = new LinkedList<Integer>(); // 숫자관련
		LinkedList<Character> opList = new LinkedList<Character>(); // 연산자 관련
		for (int j = 0; j < 100; j++) {
			Scanner scan = new Scanner(System.in);
			System.out.print("수식 입력 => ");
			String str = scan.next();
			StringTokenizer st = new StringTokenizer(str, "+-*/", true);

			String num = ""; // 연사자 외에 숫자들을 임시 저장할 곳

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i); // string을 char 타입 단위로 나눔

				if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
					numList.add(Integer.parseInt(num)); // 숫자로 바꿔서 숫자배열에 추가
					opList.add(ch); // 연산자를 연산자배열에 추가
					num = ""; // 임시로 저장된 숫자를 비워준다
					continue; // 제일 가까운 명령문으로 이동
				}
				num += ch; // 연산자 앞까지의 숫자를 임시로 넣어 놓음
			}
			numList.add(Integer.parseInt(num)); // 마지막 숫자

			while (!opList.isEmpty()) { // 연산자배열이 빌 때까지
				int prevNum = numList.poll(); // poll : 앞부터 완전히 뺀다
				int nextNum = numList.poll();
				char op = opList.poll();

				if (op == '+') {
					numList.addFirst(prevNum + nextNum); // addFirst 배열 제일 앞에 넣는다
				} else if (op == '-') {
					numList.addFirst(prevNum - nextNum);
				} else if (op == '*') {
					numList.addFirst(prevNum * nextNum);
				} else if (op == '/') {
					numList.addFirst(prevNum / nextNum);
				}
			}
			System.out.println(numList.poll());
		}
	}
}
