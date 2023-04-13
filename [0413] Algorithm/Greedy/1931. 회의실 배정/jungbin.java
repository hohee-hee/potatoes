

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//회의 수 n
		int n = Integer.parseInt(st.nextToken());
		
		int max_t = 0;
		int[][] meet = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
			if(meet[i][1]>max_t) max_t = meet[i][1];
		}
		
		//끝 시간 오름차순 ** 시간같은 경우  조건 추가
		Arrays.sort(meet, (o1, o2) -> {
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		});
		//가능 회의 번호를 담을 리스트(인덱스를 저장)
		LinkedList<Integer> list = new LinkedList<>();
		//첫 회의를 넣고 시작
		list.add(0);
		//순서대로 비교하기
		for(int i=1; i<n; i++) {
			//리스트 마지막 요소의 끝시간 보다 비교 회의의  시작 시간이 늦을 경우 넣기
			if( meet[list.peekLast()][1]<=meet[i][0]) {
				list.add(i);

			}
			
		}
		
		System.out.println(list.size());
		
	}

}
