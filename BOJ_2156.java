/*
 * 2020.02.06
 * 2156: 포도주 시식
 */
import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 포도잔의 개수
		int[] p = new int[10001];
		for(int i=1; i<n+1; i++) p[i]=sc.nextInt();
		
		int [] d=new int[10001]; //d[i]: i잔 마셨을 떄 최대
		d[0]=0; d[1]=p[1]; d[2]=p[1]+p[2];
		for(int i=3; i<n+1; i++) {
			//0번째 연속해서 마심(마시지않음): d[i-1]
			//1번째 연속해서 마심(바로 전에 안마심): d[i-2]+p[i]
			//2번째 연속해서 마심(바로 전에 마시고, 그 전에 안마심): d[i-3]+p[i-1]+p[i]
			int temp=Math.max(d[i-1],d[i-2]+p[i]);
			if(temp<d[i-3]+p[i-1]+p[i]) temp=d[i-3]+p[i-1]+p[i];
			d[i]=temp;
			
		}
		System.out.println(d[n]);
		}
}
