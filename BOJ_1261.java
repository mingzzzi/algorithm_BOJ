/*
 * 2020.02.02
 * 1261: 알고스팟
 * 가중치가 있는 그래프 - 우선순위 큐 사용
 */
import java.util.*;

public class Main {
	static int[][] array;
	static int[][] dist;
	static PriorityQueue<Point> pq;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		array = new int[n + 1][m + 1];
		dist = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			String[] string = sc.next().split(""); // string 잘라서 저장
			for (int j = 1; j < m + 1; j++) {
				array[i][j] = Integer.parseInt(string[j - 1]);
				dist[i][j] = -1; // dist 배열 초기화
			}
		}

		bfs(n, m);
	}

	public static void bfs(int n, int m) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		pq = new PriorityQueue<>();
		pq.add(new Point(1, 1, 0));
		dist[1][1] = 0;
		while (!pq.isEmpty()) {
			Point p = pq.remove();
			if (p.x == n && p.y == m) {
				System.out.println(dist[p.x][p.y]);
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 < nx && nx <= n && 0 < ny && ny <= m) {
					if (dist[nx][ny] == -1) {
						dist[nx][ny] = dist[p.x][p.y] + array[nx][ny];
						pq.add(new Point(nx, ny, dist[nx][ny]));

					}
				}
			}
		}
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int cost;

	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point target) {
		// cost 낮은 순으로 큐에 저장
		return this.cost < target.cost ? -1 : 1;
	}
}
