/*
 * 2020.02.02
 * 7576: 토마토
 */
import java.util.*;

public class Main {
	static int[][] array;
	static boolean[][] check;
	static int[][] dist;
	static Queue<Point> q = new LinkedList<Point>();

	public static void main(String agr[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int x;
		int y;

		array = new int[n][m];
		dist = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
				if (array[i][j] == -1)
					dist[i][j] = -1;
				else
					dist[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == false && array[i][j] == 1) {
					q.add(new Point(i, j));
					check[i][j] = true;
					dist[i][j] = 1;
				}
			}
		}
		bfs(n, m);
		System.out.println(print(n, m));
	}

	public static void bfs(int n, int m) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && array[nx][ny] != -1) {
					if (check[nx][ny] == false) {
						q.add(new Point(nx, ny));
						check[nx][ny] = true;
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
	}

	// print result
	public static int print(int n, int m) {
		int min = 0;
		int day = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] == 0)
					return -1;
				else {
					if (dist[i][j] >= min)
						min = dist[i][j];
				}
			}
		}
		day = min;
		return day - 1;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
