package potato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05_호희 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		//현재 좌표 입력 받기
		//atoi '0' 48 a 97... >'1'
		int a = n.charAt(0)-'a';
		//System.out.println(a);
		int b = n.charAt(1)-'1';
		//System.out.println(b);
		
		//델타
		int[]dx = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[]dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		//이동 결과 조사하기
		int cnt =0;
		for(int i=0; i<8; i++) {
			if((a+dy[i]>=0 & a+dy[i]<8) & (b+dx[i]>=0 & b+dx[i]<8)) {
				cnt++;
		
			}
		}
		System.out.println(cnt);
	}
}
