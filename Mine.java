
/**
 * It is part of the project tdd-minesweeper
 * 
 * The Mine class represents a mine with a specific position on a grid.
 * 
 * @author Team_JavaVerse 
 * @version 29-11-24
 */
public class Mine {
    private int posX;
    private int posY;
    private boolean isActive;
    
    public Mine(int posX, int posY) {  
        validateCoordinates(posX, posY);
        this.posX = posX;
        this.posY = posY;
        isActive = false;
    }
    
    public String getPosition() {
        return posX + ", " + posY;
    }
    
    private void validateCoordinates(int posX, int posY) {
        if (posX < 0 || posY < 0) {
            throw new RuntimeException("The coordinate must not be negative");
        }
    }
    
    public void setActive() {
        isActive = true;
    }
    
    public boolean isActive() {
        return isActive;
    }
}
