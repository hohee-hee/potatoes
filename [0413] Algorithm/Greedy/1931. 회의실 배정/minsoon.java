import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//회의실 최대 사용을 보자
		// 경우1. 회의실 사용시간이 젤 짧은 경우
		// 경우 2. 끝나는 시간을 기준으로, 그중 시작시간 빠른족
		int N = sc.nextInt();
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간으로 정렬
				if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int i =0; i<N; i++) {
			// 끝나는 시간을 저장하고  끝나면  다음 회의진행
			if(end <= arr[i][0]) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}

}