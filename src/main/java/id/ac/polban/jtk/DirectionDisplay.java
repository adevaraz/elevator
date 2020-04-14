package id.ac.polban.jtk;

/**
 *
 * @author Zara Veda
 */
interface DirectionDisplay {
    public enum Direction {UP, DOWN}
    
    public void show(Direction direction);
}