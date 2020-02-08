/*
 * 2020.02.08
 * 11053: 가장 긴 증가하는 부분 수열
 */

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < array.length; i++)
			array[i] = sc.nextInt();

		d[0] = 1;
		for (int i = 1; i < n; i++) {
			d[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}
