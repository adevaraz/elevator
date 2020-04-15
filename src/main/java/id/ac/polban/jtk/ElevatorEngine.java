package id.ac.polban.jtk;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author IchaCahyaWulan
 */

public class ElevatorEngine extends TimerTask{
    public enum Direction {
        UP(1),
        DOWN(-1);
        private final int value;

        Direction(int value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }
    };
    
    /**
     * Posisi ketinggian dari elevator dengan asumsi elevator berada di 
     * ketinggian 0m saat awal beroperasi
     */
    private double height = 0.0;

    /**
     * Kecepatan pergerakan elevator dengan asumsi elevator tidak bergerak
     * (bergerak dengan kecepatan 0) saat awal beroperasi
     */
    private double speed = 0;

    /**
     * Arah pergerakan elevator
     */
    private Direction direction = Direction.UP;
    
    public void run(){
        this.height += speed;
    }
    /**
     * 
     */
    public ElevatorEngine() {
        Timer timer = new Timer();
          
        timer.schedule(this, 1000, 1000); 
    }

    /**
     * Mengubah kecepatan dan arah elevator
     * @param speed     the speed in m/s
     * @param direction 
     */
    public void move(double speed, Direction direction) {
        // ubah variable height dan direction
        this.speed = speed;
        this.direction = direction;
    }

    public double getHeight() {
        return height;
    }

}