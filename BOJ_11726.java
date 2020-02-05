/*
 * 2020.02.05
 * 11726: 2*n 타일링(DP)
 */
import java.util.*;

public class Main {
	static int[] d;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		d = new int[1001];
		for (int i = 0; i < d.length; i++)
			d[i] = 0;
		System.out.println(calculate(input));
	}

	/* 재귀활용(Top-down 방식)
	public static int calculate(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if(d[n]>0) return d[n]; //이미 구해놨을 경우 --> 시간단축
		if (n >= 3) d[n] = (calculate(n - 1) + calculate(n - 2))%10007;
		return d[n];
	}
	*/
	
	public static int calculate(int n) {
		d[1]=1;
		d[2]=2;
		for(int i=3; i<n+1; i++)
			d[i]=((d[i-1]+d[i-2]))%10007;
		
		return d[n];
		
	}
}
