/*
 * 2020.02.06
 * 2193: 이친수
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long [][] d=new long[n+1][2];
		
		d[1][0]=0; d[1][1]=1;
		
		for(int i=2; i<n+1; i++) {
			d[i][0]=d[i-1][0]+d[i-1][1];
			d[i][1]=d[i-1][0];
		}
		
		System.out.println(d[n][0]+d[n][1]);
	}
}
