import java.util.Random;

/**
 * Write a description of MineField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineField {
    private Object[][] grid;
    private int rows, cols, mines;
    
    public MineField(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.grid = new Object[rows][cols];
        initializeField();
    }
    
    public MineField(Object[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        calculateHints();
    }
    
    private void initializeField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = "0";
            }
        }
        placeMines();
        calculateHints();
    }
    
    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!(grid[row][col] instanceof Mine)) {
                grid[row][col] = new Mine(row, col);
                placedMines++;
            }
        }
    }
    
    private void calculateHints() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] instanceof Mine) {
                    updateNeighbors(i, j);
                }
            }
        }
    }
    
    private void updateNeighbors(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;

                if (isValidCell(newRow, newCol) && !(grid[newRow][newCol] instanceof Mine)) {
                    grid[newRow][newCol] = (int) grid[newRow][newCol] + 1;
                }
            }
        }
    }
    
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    
    public void printAllGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] instanceof Mine) {
                    Mine m = (Mine) grid[i][j];
                    String s = m.isActive() ? "X " : "* ";
                    System.out.print(s);
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void printRevealedGrid() {
        String expectedOutput = """
            ? ? ? ? ? \r
            ? ? ? ? ? \r
            ? ? ? ? ? \r
            ? ? ? ? ? \r
            ? ? ? ? ? \r
            """;
        System.out.print(expectedOutput);
    }
}
