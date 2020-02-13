/*
 * 2020.02.13
 * 1107: 리모컨
 */
import java.util.*;

public class Main {
	static boolean[] broken; // 고장났으면 true

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int result = sc.nextInt();
		int c = sc.nextInt();

		broken = new boolean[10];
		for (int i = 0; i < c; i++)
			broken[i] = false;
		for (int i = 0; i < c; i++) {
			int number = sc.nextInt();
			broken[number] = true;
		}
		if (result == 100)
			answer = 0;
		else
			answer = calculate(result);
		System.out.println(answer);
	}

	public static int calculatelen(int result) {
		// 전체 길이 구하기
		int len = 0;
		boolean flag = true;
		int temp = result;

		if (temp == 0) {
			if (broken[temp] == true)
				flag = false;
			else
				len = 1;
		}

		else {
			while (temp > 0) {
				int i = temp % 10;
				if (broken[i] == true)
					flag = false;
				len++;
				temp /= 10;

			}
		}
		// 누를 수 없을 경우에는 0을 리턴
		if (flag == false)
			len = 0;
		return len;
	}

	public static int calculate(int result) {
		// 100에서 +,- 버튼의 이동만으로 갈 수 있는 경우의 수를 최소로 놓고 시작
		int answer = 100 - result;
		if (answer < 0)
			answer = (-1) * answer;
		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = calculatelen(c);
			if (len > 0) {
				int temp = c - result;
				if (temp < 0) {
					temp = (-1) * temp;
				}
				if (answer > temp + len)
					answer = temp + len;
			}
		}
		return answer;
	}
}
