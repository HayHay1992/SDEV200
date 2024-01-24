public class assignment6_31 {
	/** Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
    // Create a Scanner

		// Prompt user to enter a credit card number
		System.out.print("Enter a credit card number: ");
		long number = input.nextLong();

		System.out.println(
			number + " is " + (isValid(number) ? "valid" : "invalid"));
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean valid =
			(getSize(number) >= 13 && getSize(number) <= 16) &&
			(prefixMatched(number, 4) || prefixMatched(number, 5) ||
			prefixMatched(number, 37) || prefixMatched(number, 6)) &&
			((sumOfDoubleEven(number) + sumOfOdd(number)) % 10 == 0);

		return valid;
	}
	
	/** Get the result from part two */
	public static int sumOfDoubleEven(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}
	
	/** Return this number if a single digit, otherwise,
	* return the sum of both digits */
	public static int getDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}
	
	/** Return sum of odd digits in number */
	public static int sumOfOdd(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
	
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}
	
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}
	
	/** Return first k number of digits from number. If
	* number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k) {
		if (getSize(number) > k)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, k));
		}
		return number;
	}
}
