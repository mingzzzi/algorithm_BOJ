/*
 * 2020.02.02
 * 14226: 이모티콘
 */

import java.util.*;

public class Main {
	static int[] array;
	static int[][] dist;
	static Queue<Pair> q = new LinkedList<Pair>();

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int goal = sc.nextInt(); // 목표 이모티콘 개수
		array = new int[goal + 1];
		dist = new int[goal + 1][goal + 1];
		// 거리를 -1로 초기화했기 때문에 방문한 점 판별할 때 사용
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				dist[i][j] = -1;
			}
		}
		q.add(new Pair(1, 0));
		dist[1][0] = 0;

		bfs(goal);
	}

	public static void bfs(int goal) {
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int s = p.s;
			int c = p.c;

			if (goal == s) {
				System.out.println(dist[s][c]);
				break;
			}
			// 클립보드에 저장
			if (dist[s][s] == -1) {
				q.add(new Pair(s, s));
				dist[s][s] = dist[s][c] + 1;
			}

			// 붙여넣기
			if (s + c <= goal && dist[s + c][c] == -1) {
				q.add(new Pair(s + c, c));
				dist[s + c][c] = dist[s][c] + 1;
			}

			// 이모티콘 삭제
			if (s - 1 >= 0 && dist[s - 1][c] == -1) {
				q.add(new Pair(s - 1, c));
				dist[s - 1][c] = dist[s][c] + 1;
			}
		}
	}
}

class Pair {
	int s;// 화면의 이모티콘 개수
	int c;// 클립보드의 이모티콘 개수

	Pair(int s, int c) {
		this.s = s;
		this.c = c;
	}
}
