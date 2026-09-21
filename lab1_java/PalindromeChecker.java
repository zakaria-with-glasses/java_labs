import java.util.Scanner;

public class PalindromeChecker{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		 
		String word = scn.nextLine();
		int low=0;
		int high = word.length() - 1;
		int isPalindrome = 1;
		while(low < high){
			if(word.charAt(low) != word.charAt(high)){
				isPalindrome = 0;
				break;
			}
			high--;
			low++;
		}

		if(isPalindrome == 1){
			System.out.println(word + " is a palindrome.");
		}else{
			System.out.println(word + " is not a palindrome.");
		}
	}
}
