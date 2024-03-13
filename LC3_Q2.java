import java.util.Scanner;

public class LC3_Q2 {
    private char[][] board;
    private char currentPlayer;

    public LC3_Q2() {
        board = new char[3][3];
        currentPlayer = 'X';
        StartingBoard();
    }

    private void StartingBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean CheckWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return (c1 != '-' && c1 == c2 && c2 == c3);
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean placeMark2(int row, int col) throws InvalidMoveException {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            } else {
                throw new InvalidMoveException("The position is already marked! Try again.");
            }
        } else {
            throw new InvalidMoveException("Invalid move! Row and column values should be between 0 and 2.");
        }
    }

    public static class InvalidMoveException extends Exception {
        public InvalidMoveException(String message) {
            super(message);
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        LC3_Q2 game = new LC3_Q2();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Player " + game.getCurrentPlayer() + ", enter your move :");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.placeMark2(row, col)) {
                    game.printBoard();
                    if (game.CheckWin()) {
                        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                        isRunning = false;
                    } else if (game.isBoardFull()) {
                        System.out.println("It's a tie!");
                        isRunning = false;
                    } else {
                        game.changePlayer();
                    }
                }
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}