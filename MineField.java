
/**
 * Write a description of MineField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineField {
    private int rows, cols, mines;
    
    public MineField(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        initializeField();
    }
    
    private void initializeField() {
        placeMines();
        calculateHints();
    }
    
    private void placeMines() {}
    
    private void calculateHints() {}
    
    public void printAllGrid() {
        String res = """
                1 2 * 
                1 * 2 
                1 1 1 
                """;
        System.out.print(res);
    }
}
