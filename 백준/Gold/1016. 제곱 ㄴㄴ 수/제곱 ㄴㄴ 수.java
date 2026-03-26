import java.util.*;

// 백준 G1 제곱 ㄴㄴ수
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        int length = (int) (max - min + 1);


        boolean[] isChecked = new boolean[length];

        Arrays.fill(isChecked, false);

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) startIndex++;
            // 나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨
            for (long j = startIndex; pow * j <= max; j++) { // 제곱수를 true로 변경
                isChecked[(int) ((j * pow) - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!isChecked[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
