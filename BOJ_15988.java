/*
 * 2020.02.06
 * 15988: 1,2,3 더하기3(DP)
 */
import java.util.*;

public class Main {
	static long[] d;
	static int n = 1000000;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		d = new long[n + 1];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;

		for (int i = 3; i < n + 1; i++)
			d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % 1000000009;

		for (int i = 0; i < count; i++) {
			int input = sc.nextInt();
			System.out.println(d[input]);
		}
	}

}
