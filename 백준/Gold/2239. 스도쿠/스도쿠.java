import java.io.*;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] sudoku = new int[9][9];
    static boolean[][] rowWise = new boolean[9][10];
    static boolean[][] colWise = new boolean[9][10];
    static boolean[][] boardWise = new boolean[9][10];
    static int[][] emptyCells = new int[81][2];
    static int emptyCellSize = 0;
    static StringBuilder sb = new StringBuilder();


    static boolean recur(int idx) {
        if (idx == emptyCellSize) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }

        int r = emptyCells[idx][0];
        int c = emptyCells[idx][1];
        for (int i = 1; i < 10; i++) {
            if (!isValid(r, c, i)) continue;
            rowWise[r][i] = true;
            colWise[c][i] = true;
            boardWise[3*(r/3)+(c/3)][i] = true;
            sudoku[r][c] = i;
            if (recur(idx+1)) return true;
            sudoku[r][c] = 0;
            rowWise[r][i] = false;
            colWise[c][i] = false;
            boardWise[3*(r/3)+(c/3)][i] = false;
        }

        return false;
    }
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String row = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = row.charAt(j) - '0';
                rowWise[i][sudoku[i][j]] = true;
                colWise[j][sudoku[i][j]] = true;
                boardWise[3*(i/3)+(j/3)][sudoku[i][j]] = true;

                if (sudoku[i][j] == 0) {
                    emptyCells[emptyCellSize][0] = i;
                    emptyCells[emptyCellSize][1] = j;
                    emptyCellSize++;
                }
            }
        }

        recur(0);
        System.out.print(sb);
    }

    static boolean isValid(int row, int col, int num) {
        return !rowWise[row][num] && !colWise[col][num] && !boardWise[3*(row/3)+(col/3)][num];
    }
}