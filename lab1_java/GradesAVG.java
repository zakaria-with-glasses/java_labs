import java.util.Scanner;
public class GradesAVG{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.printf("Student Name: ");
		String name = scn.nextLine();

		float[] grades = new float[3];
		grades[0] = scn.nextFloat();
		grades[1] = scn.nextFloat();
		grades[2] = scn.nextFloat();

		float avg = 0;
		for(int i=0;i<3;i++){
			avg += grades[i];
		}
		avg /= 3;
		System.out.printf("%s's average is %.2f\n", name, avg);
	}
}
