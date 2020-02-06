/*
 * 2020.02.06
 * 11052: 카드 구매하기(DP)
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 구매하려고 하는 카드개수
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = sc.nextInt();
		}

		d[0] = 0;
		d[1] = p[1];
		int max = 0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				int temp = p[j] + d[i - j];
				if (temp > max)
					max = temp;
			}
			d[i]=max;
			max=0;
		}
		System.out.println(d[n]);
	}
}
