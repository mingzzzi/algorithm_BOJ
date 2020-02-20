/*
 * 2020.02.20.
 * 1525: 퍼즐
 */
import java.util.*;

public class Main {
	public static int[] dx = { -3, -1, 1, 3 };
	static Queue<Integer> q = new LinkedList<Integer>();
	static HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int start = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if (temp == 0)
					temp = 9;
				start = start * 10 + temp;
			}
		}

		d.put(start, 0);
		q.add(start);
		while (!q.isEmpty()) {
			int now_num = q.remove();

			String now = Integer.toString(now_num);
			int x = now.indexOf('9');
			for (int i = 0; i < dx.length; i++) {
				if (x%3 == 2 && i == 2)
					continue;
				if (x % 3 == 0 && i == 1)
					continue;
				int nx = x + dx[i];
				if (0 <= nx && nx < 9) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(nx);
					next.setCharAt(nx, '9');
					next.setCharAt(x, temp);
					int num = Integer.parseInt(next.toString());
					if (!d.containsKey(num)) {
						d.put(num, d.get(now_num) + 1);
						q.add(num);
					}
				}
			}
		}
		if (d.containsKey(123456789)) {
			System.out.println(d.get(123456789));
		} else {
			System.out.println("-1");
		}
	}
}
