import java.util.Scanner;

public class ArithmeticCalculator{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.printf("Enter a b: ");
		int a = scn.nextInt();
		int b = scn.nextInt();

		System.out.printf("%d + %d = %d\n",a,b, a+b);
		System.out.printf("%d - %d = %d\n",a,b, a-b);
		System.out.printf("%d * %d = %d\n",a,b, a*b);
		if(b != 0){
			System.out.printf("%d / %d = %d\n",a,b, (int) a/b);
		}else{
			System.out.printf("%d / %d = UNDEFINED\n", a, b);
		}
	}
}
