/*
 * 2020.02.08
 * 1912: 연속합 
 */

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = sc.nextInt();

		int[] d = new int[n];
		d[0] = array[0];
		for (int i = 1; i < n; i++) {
			d[i] = array[i];
			if (d[i] + d[i - 1] > d[i])
				d[i] = d[i] + d[i - 1];
		}

		int max = -1000;
		for (int i = 0; i < n; i++) {
			if (max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}
