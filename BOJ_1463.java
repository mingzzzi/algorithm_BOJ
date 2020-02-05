/*
 * 2020.02.05
 * 1463: 1로 만들기(DP)
 */
import java.util.*;

public class Main {
	static int[] d;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		d = new int[input + 1];
		for (int i = 0; i < d.length; i++)
			d[i] = 0;

		System.out.println(sum(input));
	}

	public static int sum(int n) {
		if (n == 1)
			return 0;
		if (d[n] > 0)
			return d[n];

		d[n] = sum(n-1) + 1;
		if (n % 3 == 0) {
			int temp = sum(n/3) + 1;
			if (d[n] > temp) {
				d[n] = temp;
			}
		}
		if (n % 2 == 0) {
			int temp = sum(n/2) + 1;
			if (d[n] > temp)
				d[n] = temp;
		}

		return d[n];
	}
}
