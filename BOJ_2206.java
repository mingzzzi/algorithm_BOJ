/*
 * 2020.02.03
 * 2206: 벽 부수고 이동하기
 */

import java.util.*;

public class Main {
	static int[][] array;
	static int[][][] dist;
	static Queue<Pair> q = new LinkedList<Pair>();

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		array = new int[n + 1][m + 1];
		dist = new int[n + 1][m + 1][2];
		for (int i = 1; i < n + 1; i++) {
			String[] string = sc.next().split("");
			for (int j = 1; j < m + 1; j++) {
				array[i][j] = Integer.parseInt(string[j - 1]);
				dist[i][j][0] = 0;
				dist[i][j][1] = 0;
			}
		}

		bfs(n, m);
	}

	public static void bfs(int n, int m) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		q.add(new Pair(1, 1, 0));
		dist[1][1][0] = 1; // 시작하는 점
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int flag = p.flag;

			// 목표점에 도달했을 경우 출력
			if (x == n && y == m) {
				System.out.println(dist[x][y][flag]);
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 움직일 좌표가 범위 안에 있을 경우
				if (0 < nx && nx <= n && 0 < ny && ny <= m) {
					// 다음 좌표가 벽이 아닐 때
					if (array[nx][ny] == 0 && dist[nx][ny][flag] == 0) {
						q.add(new Pair(nx, ny, flag));
						dist[nx][ny][flag] = dist[x][y][flag] + 1;
					}

					// 다음 좌표가 벽일 때 flag가 아직 0이라면(벽을 부수지 않은 상태라면)방문
					if (array[nx][ny] == 1 && flag == 0 && dist[nx][ny][0] == 0) {
						q.add(new Pair(nx, ny, 1));
						dist[nx][ny][1] = dist[x][y][flag] + 1;
					}
				}
			}
		}

		// 목표점에 도달하지 못했을 경우 -1 출력
		if (dist[n][m][0] == 0 && dist[n][m][1] == 0)
			System.out.println("-1");
	}
}

class Pair {
	int x, y, flag;

	Pair(int x, int y, int flag) {
		this.x = x;
		this.y = y;
		this.flag = flag;
	}

}
