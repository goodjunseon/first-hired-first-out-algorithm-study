import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] board;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int column, int size) {

        if (colorCheck(row, column, size)) {
            if (board[row][column] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2; // 절반으로 나눈다.

        partition(row, column, newSize); // 2사분면
        partition(row, column + newSize, newSize); // 1사분면
        partition(row + newSize, column, newSize); // 3사분면
        partition(row + newSize, column + newSize, newSize); // 4사분면

    }

    // 현재 파티션 영역의 컬러가 같은지 체크
    public static boolean colorCheck(int row, int column, int size) {

        int color = board[row][column]; // 첫 번째 원소를 기준으로 검사한다. 첫 분류때는 예를들면 [0,0]을 기준으로

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                // 색상이 같지 않다면 false로 반환한다.
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        // 정해진 파티션 만큼 순환했는데 모두 색이 같다면 true를 리턴한다.
        return true;
    }
}

