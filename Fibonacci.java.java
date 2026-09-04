import java.util.Scanner;

class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of terms: ");
		int terms = scanner.nextInt();

		if (terms <= 0) {
			System.out.println("Please enter a positive number.");
			return;
		}

		long first = 0;
		long second = 1;

		System.out.print("Fibonacci sequence: ");
		for (int i = 1; i <= terms; i++) {
			System.out.print(first + " ");

			long next = first + second;
			first = second;
			second = next;
		}
	}
}
