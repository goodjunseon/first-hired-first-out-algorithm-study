import java.util.*;

// 백준 S1 소수&팰린드롬
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int MAX = 2_000_000;
        boolean[] isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;


        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = N; i <= MAX; i++) {
            if (isPrime[i]) {
                if (isPalindrome(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    private static boolean isPalindrome(int value) {
        String stringValue = Integer.toString(value);
        int length = stringValue.length();

        for (int i = 0; i < length / 2; i++) {
            if (stringValue.charAt(i) != (stringValue.charAt(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
