import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[][][] cube = new int[N][N][N];
        int value = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int z = 0; z < N; z++) {
                    cube[z][x][y] = value++;
                }
            }
        }

        for (int z = 0; z < N; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.print(cube[z][x][y]);
                    if (y != N - 1) System.out.print(" ");
                }
                System.out.println();
            }
            if (z != N - 1) System.out.println();
        }
    }
}

