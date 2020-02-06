/*
 * 2020.02.06
 * 15990: 1,2,3 더하기5(DP)
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt(); // test case 개수
		long[][] d = new long[100001][4];
		long mod = 1000000009;

		d[1][1] = 1;
		d[2][2] = 1;
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;

		for (int i = 4; i < d.length; i++) {
			d[i][1] = (d[i - 1][2] + d[i - 1][3]) % mod;
			d[i][2] = (d[i - 2][1] + d[i - 2][3]) % mod;
			d[i][3] = (d[i - 3][1] + d[i - 3][2]) % mod;
		}

		for (int i = 0; i < count; i++) {
			int input = sc.nextInt();
			System.out.println((d[input][1] + d[input][2] + d[input][3]) % mod);
		}

	}
}
