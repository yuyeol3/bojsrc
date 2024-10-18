import java.util.*;


interface Pr10997 {
    void solve(Board board);
}

class MultiRectangle implements Pr10997 {
    private final Pr10997 thisRectangle;
    private final Pr10997 nextRectangle;
    public MultiRectangle(int n, int row, int col) {
        thisRectangle = new OpenRectangle(n, row, col);
        if (n == 2)
            nextRectangle = new ClosedRectangle(row+2, col+2);
        else
            nextRectangle = new MultiRectangle(n-1, row+2, col+2);
    }

    public void solve(Board board) {
        thisRectangle.solve(board);
        nextRectangle.solve(board);
    }


}

class OpenRectangle implements Pr10997{
    private final int num, row, col;
    public OpenRectangle(int n, int row, int col) {
        this.num = n;
        this.row = row;
        this.col = col;
    }

    public void solve(Board board) {
        int rowNum = num * 4 - 1;
        int colNum = (1 + 4 *(num -1));

        for (int i = 0 ; i < colNum; ++i) {
            board.putStar(row, col+i);
            board.putStar(row+rowNum-1, col+i);
        }
        board.putStar(row+1, col);
        board.putStar(row+2, col+colNum-2);
        for (int i = 2; i < rowNum-1; ++i) {
            board.putStar(row+i, col);
            board.putStar(row+i, col+colNum-1);
        }

    }
}

final class ClosedRectangle implements Pr10997{
    private final int row, col;
    public ClosedRectangle(int row, int col) {
        this.row = row;
        this.col = col;

    }

    public void solve(Board board) {
        board.putStar(row, col);
        board.putStar(row+1, col);
        board.putStar(row+2, col);
    }
}
class InputOne implements Pr10997 {
    private final int row, col;
    public InputOne(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void solve(Board board) {
        board.putStar(row,col);
    }
}

class Board {
    private final char[][] board;
    private final int rowNum, colNum;
    public Board(int n) {
        rowNum = n == 1 ? 1 : n * 4 - 1;
        colNum = (1 + 4 *(n -1));
        board = new char[rowNum][colNum];
    }

    public void putStar(int x, int y) {
        board[x][y] = '*';
    }

    public void print() {
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (board[i][colNum-1] == '*')
                    System.out.print(board[i][j] == '*' ? '*' : ' ');
                else if (board[i][j] == '*')
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Pr10997 p;
        if (n == 1) {
            p = new InputOne(0, 0);
        } else {
            p = new MultiRectangle(n, 0, 0);
        }

        Board board = new Board(n);
        p.solve(board);
        board.print();
    }
}