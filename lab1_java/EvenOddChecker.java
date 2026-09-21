import java.util.Scanner;
public class EvenOddChecker{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		System.out.printf("a: ");
		int a = scn.nextInt();
		// not implementing loops at this stage so I'm going to work with a one iteration program for now.

		if(a % 2 == 0){
			System.out.printf("%d is even\n", a);
		}else{
			System.out.printf("%d is odd\n", a);
		}
	}
}
