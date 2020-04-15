package id.ac.polban.jtk;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author IchaCahyaWulan
 */

public class ElevatorEngine extends TimerTask {   
    private double height = 0.0;

    private double speed = 0;

    private Direction direction = Direction.UP;

    public ElevatorEngine() {
        Timer timer = new Timer(true);

        timer.schedule(this, 1000, 1000);
    }

    
    public void move(double speed, Direction direction) {
        synchronized (this) {
            this.speed = speed;
    
            this.direction = direction;
        }
    }

    public double getHeight() {
        synchronized (this) {
            return height;
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            this.height += this.speed;
        }
    }
}