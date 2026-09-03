public class Fibonacci {
    public static void main(String[] args) {
        int numTerms = 10;
        int a = 0;
        int b = 1;

        System.out.println("First " + numTerms + " Fibonacci numbers:");

        for (int i = 0; i < numTerms; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }
}
