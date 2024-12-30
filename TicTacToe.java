
import java.io.*;

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
        computerMove(board);
        playerMove(board);
        display(board);
        int i = 0;
        for (String cell : board) {
            if (cell != "X" && cell != "O") {
                break;
            } else if ((board[0] == "X" && board[1] == "X" && board[2] == "X")
                    || (board[3] == "X" && board[4] == "X" && board[5] == "X")
                    || (board[6] == "X" && board[7] == "X" && board[8] == "X")
                    || (board[0] == "X" && board[3] == "X" && board[6] == "X")
                    || (board[1] == "X" && board[4] == "X" && board[7] == "X")
                    || (board[2] == "X" && board[5] == "X" && board[8] == "X")
                    || (board[0] == "X" && board[4] == "X" && board[8] == "X")
                    || (board[2] == "X" && board[4] == "X" && board[6] == "X")) {
                System.out.println("You WIN!!!");
                return;

            } else if ((board[0] == "O" && board[1] == "O" && board[2] == "O")
                    || (board[3] == "O" && board[4] == "O" && board[5] == "O")
                    || (board[6] == "O" && board[7] == "O" && board[8] == "O")
                    || (board[0] == "O" && board[3] == "O" && board[6] == "O")
                    || (board[1] == "O" && board[4] == "O" && board[7] == "O")
                    || (board[2] == "O" && board[5] == "O" && board[8] == "O")
                    || (board[0] == "O" && board[4] == "O" && board[8] == "O")
                    || (board[2] == "O" && board[4] == "O" && board[6] == "O")) {
                System.out.println("The Computer wins");
                return;

            } else {
                i++;
                if (i == board.length) {
                    System.out.println("Its a Tie!!!");
                    return;
                }
            }
        }
        TicTacToe.gamePlay(board);
    }

    public static String[] computerMove(String[] board) {
        String newBoard[] = {};
        int i = 0;
        for (String element : board) {

            if (element != ("X") && element != ("O")) {

                board[i] = "O";
                newBoard = board;
                display(newBoard);
                return newBoard;
            }
            i++;
        }
        return board;
    }

    public static String[] playerMove(String[] board) throws IOException {
        int i = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String userSelection = input.readLine();
        String newBoard[] = {};
        for (String element : board) {
            if (element.equals(userSelection)) {
                board[i] = "X";
                newBoard = board;
                return newBoard;
            }
            i++;
        }
        return board;
    }
}