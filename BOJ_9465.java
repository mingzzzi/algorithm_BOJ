/*
 * 2020.02.06
 * 9465: 스티커
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();// testcase
		int[][] cost;
		int[][] d;
		
		for (int k = 0; k < count; k++) {
			int n = sc.nextInt();
			cost = new int[2][n + 1];
			d = new int[n + 1][3];
			
			for (int h = 0; h < 2; h++) {
				for (int w = 0; w < n; w++)
					cost[h][w] = sc.nextInt();
			}
			
			d[0][0] = 0;
			d[0][1] = 0;
			d[0][2] = 0;

			for (int i = 1; i < n + 1; i++) {

				// d[i][0]
				int temp = 0;
				temp = Math.max(d[i - 1][0], d[i - 1][1]);
				if (temp < d[i - 1][2])
					temp = d[i - 1][2];
				d[i][0] = temp;

				// d[i][1]
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + cost[0][i-1];

				// d[i][2]
				d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + cost[1][i-1];
			}

			int temp = 0;
			temp = Math.max(d[n][0], d[n][1]);
			if (temp < d[n][2])
				temp = d[n][2];

			System.out.println(temp);
		}
	}
}
