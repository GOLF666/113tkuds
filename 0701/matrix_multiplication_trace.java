public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};       
        int[][] b = {{5, 6}, {7, 8}};       
        int[][] c = new int[2][2];          

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int p0 = a[i][0] * b[0][j];
                int p1 = a[i][1] * b[1][j];
                System.out.println("計算位置 c[" + i + "][" + j + "]："
                    + a[i][0] + "*" + b[0][j]
                    + " + " + a[i][1] + "*" + b[1][j]
                    + " = " + p0 + " + " + p1
                    + " = " + (p0 + p1));
                c[i][j] = p0 + p1;          
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}