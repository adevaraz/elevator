package id.ac.polban.jtk;

public class CabNavigator implements CabNavigatorResponse {
    private final ElevatorEngine engine;

    private final DirectionDisplay directionDisplay;

    private final FloorNumberDisplay floorNumberDisplay;

    private Direction direction = Direction.UP;

    private double speed = 0.5;

    private int floorNumber = 0;

    private boolean isSuspended = false;

    /**
     * contributor: Raefaldhi Amartya J
     */
    public CabNavigator(ElevatorEngine engine, DirectionDisplay directionDisplay,
            FloorNumberDisplay floorNumberDisplay) {
        this.engine = engine;

        this.directionDisplay = directionDisplay;

        this.floorNumberDisplay = floorNumberDisplay;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private DirectionDisplay getDirectionDisplay() {
        return directionDisplay;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private FloorNumberDisplay getFloorNumberDisplay() {
        return floorNumberDisplay;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private void setDirection(Direction direction) {
        this.direction = direction;

        // Update the direction display
        this.getDirectionDisplay().show(this.direction);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public int getFloorNumber() {
        synchronized (this) {
            return floorNumber;
        }
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;

        // Update the floor number display
        this.getFloorNumberDisplay().show(this.floorNumber);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public boolean isSuspended() {
        synchronized (this) {
            return isSuspended;
        }
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    private void setSuspended(boolean isSuspended) {
        synchronized (this) {
            this.isSuspended = isSuspended;
        }
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void suspend() {
        this.setSuspended(true);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void resume() {
        this.setSuspended(false);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public interface MoveToCallback {
        public void onFloorChanged(CabNavigatorResponse response, int floorNumber);

        public void onFinished();
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void moveTo(int floorNumber, MoveToCallback moveToCallback) {
        System.out.println("moveTo(floorNumber: " + floorNumber + ")");

        setDirection(this.floorNumber > floorNumber ? Direction.DOWN : Direction.UP);

        while (this.getFloorNumber() != floorNumber && !this.isSuspended()) {
            engine.move(speed, direction);

            // TODO: Change with PositionMarkerSensor + ElevatorEngine
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setFloorNumber(this.getFloorNumber() + direction.getValue());

            moveToCallback.onFloorChanged(this, this.getFloorNumber());

            // int oldFloornumber = this.getFloorNumber();
            
            // // Wait for the floorNumber to change
            // while (true) {
            //     if (oldFloornumber != this.getFloorNumber()) {
            //         moveToCallback.onFloorChanged(this, this.getFloorNumber());
            //         break;
            //     }
            // }
        }
        moveToCallback.onFinished();
    }

    /**
     * contributor: Icha Cahya W
     */
    public void markerDetected() {
        synchronized (this) {
            // setFloorNumber(this.getFloorNumber() + direction.getValue());
        }
    }
}