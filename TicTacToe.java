
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {
    public static void main(String[] args) throws IOException {
        String board[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println("Hello, Welcome to my Tic Tac Toe game, the Computer will make the first move.....");
        TicTacToe.gamePlay(board);
    }

    public static String[] display(String[] board) {
        String columns = String.join(" ", "|     ", "|     ", "|    ", "|");
        String rows = String.join(" ", "---------------------");

        System.out.println(rows);
        for (int i = 0; i < board.length; i++) {
            System.out.println(columns);
            System.out.println("|  " + board[i] + "   |   " + board[i += 1] + "  |  " + board[i += 1] + "  |");
            System.out.println(columns);
            System.out.println(rows);
        }
        return board;
    }

    public static void gamePlay(String[] board) throws IOException {
        winCheck(board);
        computerMove(board);
        winCheck(board);
        playerMove(board);
        TicTacToe.gamePlay(board);
    }

    public static void winCheck(String[] board) {
        int i = 0;
        boolean winner = false;
        for (String cell : board) {

            if ((board[0] == "X" && board[1] == "X" && board[2] == "X")
                    || (board[3] == "X" && board[4] == "X" && board[5] == "X")
                    || (board[6] == "X" && board[7] == "X" && board[8] == "X")
                    || (board[0] == "X" && board[3] == "X" && board[6] == "X")
                    || (board[1] == "X" && board[4] == "X" && board[7] == "X")
                    || (board[2] == "X" && board[5] == "X" && board[8] == "X")
                    || (board[0] == "X" && board[4] == "X" && board[8] == "X")
                    || (board[2] == "X" && board[4] == "X" && board[6] == "X")) {
                System.out.println("You WIN!!!");
                winner = true;

            } else if ((board[0] == "O" && board[1] == "O" && board[2] == "O")
                    || (board[3] == "O" && board[4] == "O" && board[5] == "O")
                    || (board[6] == "O" && board[7] == "O" && board[8] == "O")
                    || (board[0] == "O" && board[3] == "O" && board[6] == "O")
                    || (board[1] == "O" && board[4] == "O" && board[7] == "O")
                    || (board[2] == "O" && board[5] == "O" && board[8] == "O")
                    || (board[0] == "O" && board[4] == "O" && board[8] == "O")
                    || (board[2] == "O" && board[4] == "O" && board[6] == "O")) {
                System.out.println("The Computer wins");
                winner = true;
            } else if (cell != "X" && cell != "O") {
                break;
            } else {
                i++;
                if (i == board.length) {
                    System.out.println("Its a Tie!!!");
                    winner = true;
                }
            }
            if (winner) {
                display(board);
                System.exit(i);
            }
        }
        display(board);
    }

    public static String[] computerMove(String[] board) {
        String newBoard[] = {};
        int index = 0;
        while (index < 40) {
            int randomCell = ThreadLocalRandom.current().nextInt((board.length));
            if (board[randomCell] != ("X") && board[randomCell] != ("O")) {
                board[randomCell] = "O";
                newBoard = board;
                return newBoard;
            }
        }
        return board;
    }

    public static String[] playerMove(String[] board) throws IOException {
        for (int j = 0; j < 3; j++) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select X's spot:");
            String userSelection = input.readLine();
            String newBoard[] = {};
            int indexPlayer = 0;
            for (String element : board) {
                if ((element.equals(userSelection)) && (board[indexPlayer] != "X") && (board[indexPlayer] != "O")) {
                    board[indexPlayer] = "X";
                    newBoard = board;
                    return newBoard;
                }
                indexPlayer++;
            }
            System.out.println(
                    "The character chosen doesn't exist on the board, select a valid number between 1-9 that exists on the current board.");
            if (j == 2) {
                System.out.println("Exiting game due to incorrect player input.");
                System.exit(j);
            }
        }
        return board;
    }
}