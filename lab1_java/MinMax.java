import java.util.Scanner;

public class MinMax{
	public static void main(String[] args){
		int Min=0,Max=0;
		int elem = nextInt(); 
		while(elem != null){
			if(elem < Min){
				Min = elem;
			}
			if (elem > Max){
				Max = elem;
			}
			elem = nextInt();
		}

		System.out.printf("Min = %d, Max = %d\n", Min, Max);
	}
}
