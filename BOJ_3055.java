/*
 * 2020.02.03
 * 3055: 탈출
 */
import java.util.*;

public class Main {
	static String[][] array;
	static int[][] dist;
	static int[][] water;
	static Queue<Pair> q = new LinkedList<Pair>();
	static Queue<Pair> wq = new LinkedList<Pair>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int endX, endY = 0;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		array = new String[r][c];
		dist = new int[r][c];
		water = new int[r][c]; // 물이 들어오는 시간 저장
		for (int i = 0; i < r; i++) {
			String[] string = sc.next().split("");
			for (int j = 0; j < c; j++) {
				array[i][j] = string[j];
				dist[i][j] = -1;
				water[i][j] = -1;
				if (string[j].equals("*")) {
					wq.add(new Pair(i, j));
					water[i][j] = 0;
				}
				if (string[j].equals("S")) {
					q.add(new Pair(i, j));
					dist[i][j] = 0;
				}
				if (string[j].equals("D")) {
					endX = i;
					endY = j;
				}
			}
		}

		waterIn(r, c);
		bfs(r, c, endX, endY);
	}

	public static void bfs(int r, int c, int endX, int endY) {

		while (!q.isEmpty()) {
			Pair p = q.remove();

			// 도착했을 경우
			if (array[p.x][p.y].equals("D")) {
				System.out.println(dist[p.x][p.y]);
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < r && 0 <= ny && ny < c && dist[nx][ny] == -1) {
					if (array[nx][ny].equals(".") || array[nx][ny].equals("D")) {
						// 물이 차지 않는 곳 || 물 들어오는 시간보다 dist가 작음 || 도착점
						if (water[nx][ny]==-1 || dist[p.x][p.y] + 1 < water[nx][ny] || array[nx][ny].equals("D")) {
							q.add(new Pair(nx, ny));
							dist[nx][ny] = dist[p.x][p.y] + 1;
						}
					}
				}
			}
		}

		if (dist[endX][endY] == -1)
			System.out.println("KAKTUS");

	}

	// make water array
	public static void waterIn(int r, int c) {
		while (!wq.isEmpty()) {
			Pair wp = wq.remove();
			for (int i = 0; i < dx.length; i++) {
				int nx = wp.x + dx[i];
				int ny = wp.y + dy[i];
				if (0 <= nx && nx < r && 0 <= ny && ny < c) {
					if (water[nx][ny] == -1 && (array[nx][ny].equals(".") || array[nx][ny].equals("S"))) {
						wq.add(new Pair(nx, ny));
						water[nx][ny] = water[wp.x][wp.y] + 1;
					}
				}
			}
		}
	}

}

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
