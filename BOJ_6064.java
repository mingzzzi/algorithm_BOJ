/*
 * 2020.02.15
 * 6064: 카잉달력
 * 브루트 포스(건너 뛰며 해보기)
 */

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int m, n, x, y;
		int c = sc.nextInt();
		for (int i = 0; i < c; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			boolean flag = false;
			int year;
			for (year = x; year <= m * n; year = year + m) {
				//n==y일 때 예외처리
				if (n == y) {
					if (year % n == y || year % n == 0) {
						flag = true;
						break;
					}
				} else if (year % n == y) {
					flag = true;
					break;
				}
			}
			if (flag == true)
				System.out.println(year);
			else
				System.out.println(-1);

		}
	}
}
