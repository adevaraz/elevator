package id.ac.polban.jtk;

public class ElevatorEngine {
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
     * 
     * @param speed     the speed in m/s.
     * @param direction 
     */
    void move(double speed, Direction direction) {

    }
}