/*
 * 2020.02.18
 * 1748: 수 이어 쓰기1
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n;
		int len = 0;
		while (temp > 0) {
			temp /= 10;
			len++;
		}

		int sum = 0;
		int t = 9;
		for (int i = 1; i < len + 1; i++) {
			// 마지막일 경우 예외처리
			if (i == len) {
				t /= 9;
				sum += i * ((n - t) + 1);
			} else {
				sum += i * t;
				t *= 10;
			}
		}
		System.out.println(sum);
	}
}
