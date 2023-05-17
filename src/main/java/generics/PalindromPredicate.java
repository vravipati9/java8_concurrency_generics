package generics;

import generics.model.UnaryPredicate;

public class PalindromPredicate implements UnaryPredicate<Integer> {
	@Override
	public boolean test(Integer i) {
		return isPalindrome(i);
	}
	
	private boolean isPalindrome(Integer number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (number == reverse) {
            return true;
        }
        return false;
    }

}
