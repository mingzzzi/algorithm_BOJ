package _13913;
/*
 * 2020.02.18
 * 13913: 숨바꼭질4
 */

import java.util.*;

public class Main {
	static int[][] array;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		array = new int[100001][2];
		for (int i = 0; i < array.length; i++) {
			array[i][0] = -1;
		}

		bfs(n, k);
	}

	public static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		int p = 0;
		array[n][0] = 0;
		q.add(n);
		while (!q.isEmpty()) {
			p = q.remove();
			if (p == k)
				break;
			if (p - 1 >= 0 && array[p - 1][0] == -1) {
				q.add(p - 1);
				array[p - 1][0] = array[p][0] + 1;
				array[p - 1][1] = p;
			}

			if (p + 1 <= 100000 && array[p + 1][0] == -1) {
				q.add(p + 1);
				array[p + 1][0] = array[p][0] + 1;
				array[p + 1][1] = p;
			}

			if (2 * p <= 100000 && array[2 * p][0] == -1) {
				q.add(2 * p);
				array[2 * p][0] = array[p][0] + 1;
				array[2 * p][1] = p;
			}
		}

		System.out.println(array[p][0]);

		//print result
		int[] result = new int[array[p][0] + 1];
		for (int i = array[p][0]; i >= 0; i--) {
			result[i] = k;
			k = array[k][1];
		}

		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}
