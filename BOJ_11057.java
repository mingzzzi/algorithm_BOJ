/*
 * 2020.02.06
 * 11057: 오르막 수
 */

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[n + 1][10];

		// 초기값&예외처리
		for (int i = 0; i <= 9; i++)
			d[1][i] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j <= 9; j++) {
				// 0으로 끝나는 경우
				if (j == 0)
					d[i][j] = 1;
				else {
					for (int k = 0; k <= j; k++)
						d[i][j] = (d[i][j] + d[i - 1][k]) % 10007;

				}
			}
		}

		// result
		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result += d[n][i];
		}
		System.out.println(result % 10007);
	}
}
