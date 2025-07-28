import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            int row, col;

            while (true) {
                System.out.print("Enter row (1-3): ");
                row = sc.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = sc.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("Cell already taken. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }

            printBoard();

            // Check for winner
            if (checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                // Here we are going to Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
       
    public static boolean checkWinner(char player) {
        // Here we are Checking rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Rows and Columns
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
