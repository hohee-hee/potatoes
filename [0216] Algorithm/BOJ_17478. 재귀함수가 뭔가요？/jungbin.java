import java.util.Scanner;

public class P01_17478 {
	
	static String underbar = "";
	
	public static void reculsive (int n) {
    
		String temp = underbar;
		
		String question = "\"재귀함수가 뭔가요?\"";
		String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		String answer3 = "그의 답은 대부분 옳았다고 하네. 그러던 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String answer4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		String answer5 = "라고 답변하였지.";
		
		System.out.println(temp + question);
		
		if (n == 0) {
			System.out.println(temp + answer4);
			System.out.println(temp + answer5);
			return;
		}
		
		if (n > 0) {
			System.out.println(temp + answer1);
			System.out.println(temp + answer2);
			System.out.println(temp + answer3);
			
			underbar += "____";
			
			reculsive(n-1);
			
			System.out.println(temp + answer5);
		}	
	}


	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		reculsive(num);
		
		scanner.close();
	}
}