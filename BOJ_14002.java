/*
 * 2020.02.08
 * 14002: 가장 긴 증가하는 부분 수열 4
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int[][] d = new int[n][2];

		for (int i = 0; i < n; i++)
			array[i] = sc.nextInt();

		d[0][0] = 1;
		d[0][1] = 0;
		for (int i = 1; i < n; i++) {
			d[i][0] = 1;
			d[i][1] = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j] && d[i][0] < d[j][0] + 1) {
					d[i][0] = d[j][0] + 1;
					d[i][1] = j;
				}
			}
		}

		int max = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (max < d[i][0]) {
				max = d[i][0];
				index = i;
			}
		}

		// 부분 수열 역추적
		int[] result = new int[max];
		for (int i = max - 1; i >= 0; i--) {
			result[i] = array[index];
			index = d[index][1];
		}

		// print result
		System.out.println(max);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

}
