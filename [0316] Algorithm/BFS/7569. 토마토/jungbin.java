//다 한 것 같은데 다 익는데 걸리는 날짜 수를 어디서 세야 할지 모르겠다.
//익은 토마토를 발견하고
//인접해있는 안익은 토마토가 있는 경우에만 더해주고 싶은데 있는 경우에 1번만 중복을 어케 제외함??
//생각은 났음 새로운 배열을 만들어서 처음에는 0 그다음에는 큐 넣기 전 좌표의 값의+1  여기서 처음0일때 더해진 1은 구분해야 하나...그런데 너무 길어지는 거 아닌가?
package day0315;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P7569_토마토 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//상자의 가로 M
		int m = sc.nextInt();
		//상자의 세로 n
		int n = sc.nextInt();
		//상자 수 h
		int h = sc.nextInt();
		
		//결과 확인
		boolean ch = true;
		
		//최소 날짜 수
		int cnt=0;
		
		//토마토 배열 입력
		int[][][] toma = new int[h][n][m];
		for(int a=0; a<h; a++) {
			for(int b=0; b<n; b++) {
				for(int c=0; c<m; c++) {
					toma[a][b][c]=sc.nextInt();
				}
			}
		}
		//델타
		int[] dh = {-1, 1, 0, 0, 0, 0};
		int[] dn = {0, 0, 0, 0, -1, 1};
		int[] dm = {0, 0, -1, 1, 0, 0};
		
		//탐색 저장할 큐 
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		//탐색
		for(int a=0; a<h; a++) {
			for(int b=0; b<n; b++) {
				for(int c=0; c<m; c++) {
					//익은 토마토 발견
					if(toma[a][b][c]==1) {
						//자신 표시
						toma[a][b][c]=0;
						
						//자기 좌표 기억
						int[] array = new int[3];
						array[0]=a;
						array[1]=b;
						array[2]=c;
						q.offer(array);
						
						while(!q.isEmpty()) {
							int[]arr = q.poll();
							int nh = arr[0];
							int nn = arr[1];
							int nm = arr[2];
							
							//탐색
							for(int d=0; d<6; d++) {
								int z = nh+dh[a];
								int x = nn+dn[a];
								int y = nm+dm[a];
								//범위 조건 제외
								if(z<0 || x<0 || y<0 || z>=h || x>=n || y>=m) continue;
								//안익은 토마토 바꿔주기
								if(toma[z][x][y]==0) {
									toma[z][x][y]=1;
									int[]array1 = new int[3];
									array1[0]=z;
									array1[1]=x;
									array1[2]=y;
									q.offer(array1);
								}
							}
						}
						
					}
				}
			}
		}
	
		//토마토 상태 확인 > 출력 
		for(int a=0; a<h; a++) {
			for(int b=0; b<n; b++) {
				for(int c=0; c<m; c++) {
					if(toma[a][b][c]==0)
						ch=false;
				}
			}
		}
		if(ch) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}

}
