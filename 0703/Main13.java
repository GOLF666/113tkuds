import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[][] matrix = new int[N][N];
        int[] dx = {0, 1, 0, -1}; 
        int[] dy = {1, 0, -1, 0}; 
        int dir = 0;  

        int x = 0, y = 0;
        for (int i = 1; i <= N * N; i++) {
            matrix[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || matrix[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                if (j != N - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
