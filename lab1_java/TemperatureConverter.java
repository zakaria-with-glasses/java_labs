import java.util.Scanner;//https://www.w3schools.com/java/java_user_input.asp
public class TemperatureConverter {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		System.out.printf("Enter temperature in C: ");
		float temp = scn.nextFloat();

		float result = (float) 1.8*temp + 32;

		System.out.printf("Temp in C %s\nTemp in F %s\n", temp, result);
	}
}
