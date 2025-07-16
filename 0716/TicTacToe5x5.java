import java.util.Scanner;

public class TicTacToe5x5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '.';
            }
        }
        
        System.out.println("=== 5x5 井字遊戲 ===\n");
        printBoard(board);
        
        char currentPlayer = 'X';
        int moveCount = 0;
        
        while (true) {
            int row, col;
            while (true) {
                System.out.print("請輸入 row col (0-4): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row < 0 || row > 4 || col < 0 || col > 4) {
                    System.out.println("輸入超出範圍，請重新輸入！");
                }
                else if (board[row][col] != '.') {
                    System.out.println("該位置已被佔用，請重新輸入！");
                }
                else {
                    break; 
                }
            }
            
            board[row][col] = currentPlayer;
            moveCount++;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子%n", currentPlayer, row, col);
            
            printBoard(board);
            
            if (checkWin(board, currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！%n", currentPlayer);
                break; 
            }
            if (moveCount == 25) {
                System.out.println("平手！");
                break; 
            }
            
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        
        scanner.close();
    }
    
    public static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int col = 0; col < 5; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        
        for (int row = 0; row < 5; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 5; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(); 
    }
    
    public static boolean checkWin(char[][] board, char player) {
        for (int row = 0; row < 5; row++) {
            boolean win = true;
            for (int col = 0; col < 5; col++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
        for (int col = 0; col < 5; col++) {
            boolean win = true;
            for (int row = 0; row < 5; row++) {
                if (board[row][col] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
        boolean win = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;
        
        win = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != player) {
                win = false;
                break;
            }
        }
        return win;
    }
}
