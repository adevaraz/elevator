package id.ac.polban.jtk;

public interface SummonRequestLogger {
    public void pressed(final int floorNumber, final Direction direction);
 
    public void released(final int floorNumber, final Direction direction);
}