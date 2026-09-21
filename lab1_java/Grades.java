import java.util.Scanner;

public class Grades{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		float[] grades = new float[5];
		for(int i=0; i<5; i++){
			float grade = scn.nextFloat();
			grades[i] = grade;
		}
		System.out.printf("Grades: ");
		for(int j=0; j<5; j++){
			System.out.printf("%.2f, ", grades[j]);
		}
		System.out.printf("\n");
	}
}
