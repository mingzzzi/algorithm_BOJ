/*
 * 2020.02.08
 * 2225: 합분해
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] d = new long[k + 1][n + 1];

		d[0][0] = 1;
		for (int i = 1; i < k + 1; i++) {
			for (int j = 0; j < n+1; j++) {
				for (int l = 0; l < j+1; l++) {
					d[i][j] += d[i - 1][j - l];
					d[i][j]%=1000000000;
				}
			}
		}
		System.out.println(d[k][n]);
	}
}
