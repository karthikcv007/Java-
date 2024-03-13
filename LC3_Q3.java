import java.util.Scanner;
import java.util.Random;

interface Player {
    void play(LC3_Q3 game) throws LC3_Q3.InvalidMoveException;
}

class HumanPlayer implements Player {
    private char symbol;

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void play(LC3_Q3 game) throws LC3_Q3.InvalidMoveException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + symbol + ", enter your move (row[0-2] column[0-2]):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        game.placeMark(row, col, symbol);
        game.printBoard();
    }
}

class ComputerPlayer implements Player {
    private char symbol;

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void play(LC3_Q3 game) throws LC3_Q3.InvalidMoveException {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!game.placeMark(row, col, symbol));
        System.out.println("Computer played: row " + row + ", col " + col);
        game.printBoard();
    }
}

public class LC3_Q3 {
    private char[][] board;
    private char currentPlayer;

    public LC3_Q3() {
        board = new char[3][3];
        currentPlayer = 'X';
        startingBoard();
    }

    private void startingBoard() {
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

    public boolean checkWin() {
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


    public boolean placeMark(int row, int col, char symbol) throws InvalidMoveException {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = symbol;
                return true;
            } else {
                throw new InvalidMoveException("Cell already marked! Try again.");
            }
        } else {
            throw new InvalidMoveException("Invalid move! Row and column values should be between 0 and 2.");
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static class InvalidMoveException extends Exception {
        public InvalidMoveException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        LC3_Q3 game = new LC3_Q3();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        Player humanPlayer = new HumanPlayer('X');
        Player computerPlayer = new ComputerPlayer('O');
        Player currentPlayer = humanPlayer;

        while (isRunning) {
            try {
                currentPlayer.play(game);
                if (game.checkWin()) {
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    isRunning = false;
                } else if (game.isBoardFull()) {
                    System.out.println("It's a tie!");
                    isRunning = false;
                } else {
                    currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
                }
            } catch (LC3_Q3.InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
