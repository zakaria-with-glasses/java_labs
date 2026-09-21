import java.util.Scanner;

public class ReverseString{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		String original = scn.nextLine();

		for(int i=original.length()-1; i>-1; i--){
			System.out.printf("%c", original.charAt(i));
		} 
		System.out.println("");
	}
}
