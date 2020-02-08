/*
 * 2020.02.08
 * 1699: 제곱수의 합
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n + 1];

		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			d[i] = i;
			for (int j = 1; j * j <= i; j++) {
				int temp = d[i - j * j] + 1;
				if (d[i] > temp)
					d[i] = temp;
			}
		}

		System.out.println(d[n]);
	}
}
