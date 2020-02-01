import java.util.*;

public class Main{

	static int[][] array;
	static boolean[][] check;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w, h;
			int count = 0;
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			array = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int value = sc.nextInt();
					array[i][j] = value;
				}
			}
			check = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (array[i][j] == 1 && check[i][j] == false) {
						bfs(i, j, h, w);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void bfs(int x, int y, int h, int w) {
		int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		check[x][y] = true;
		while (!q.isEmpty()) {
			Point point = q.remove();
			x = point.x;
			y = point.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (check[nx][ny] == false && array[nx][ny] == 1) {
						q.add(new Point(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
		}
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
