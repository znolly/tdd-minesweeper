
/**
 * Write a description of Mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mine {
    private int posX;
    private int posY;
    
    public Mine(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public String getPosition() {
        return posX + ", " + posY;
    }
}
