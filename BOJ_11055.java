/*
 * 2020.02.08
 * 11055: 가장 큰  증가 부분 수열
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		d[0] = array[0];
		for (int i = 1; i < n; i++) {
			d[i] = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j] && d[i] < d[j] + array[i])
					d[i] = d[j] + array[i];
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
