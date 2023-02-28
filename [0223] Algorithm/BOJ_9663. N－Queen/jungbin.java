package potato;

//이해를 못하겠는데...ㅜ
public class N_Queen {
	
	//n*n 배열에서  n개의 체스 퀸 배치
	//n개의 체스 퀸
	static int n =4;
	//체스 판
	static int[][] board = new int[4][4];
	
	public static void main(String[] args) {
		//배치가 불가능 한 경우 false가 나옴
		if(put_queen(0)==false) {
			System.out.println("해가 없음");
		} else {
			//배치가 가능한 경우 1과 0의 배열을 구할 수 있음
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(board[i][j]+ ",");
				}
				System.out.println();
			}
		}
	}
	
	//퀸 배치하기
	private static boolean put_queen(int col) {
		//열을 모두 조사했다면 종료하기
		if(col >= n) return true;
		//해당 열에서 조사 
		for(int i=0; i<n; i++) {
			//배치가 가능하다면 위치에서 1
			if(check(i, col)==true) {
				board[i][col]=1;
				//다음열 배치 가능 여부?
				if(put_queen(col+1)==true) {
					return true;
				}
				//이건 어떻게 적용되는 거야?? 1도 덮어쓰게 되는 거 아닌가..?
				board[i][col]=0;
			}
		}
		return false;
	}
	
	//가능 위치
	private static boolean check(int row, int col) {
		int i,j;
		//행을 조사했을 때 1이 이미 있다면 불가
		for(i=0; i<col; i++) {
			if(board[row][i]==1) {
				return false;
			}
		}
		//대각선 위치에서 이미 있다면 불가
		for(i = row, j=col; i>=0 && j >=0; i--, j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		for(i=row, j=col; i<n && j>=0; i++, j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		return true;
	}

}
