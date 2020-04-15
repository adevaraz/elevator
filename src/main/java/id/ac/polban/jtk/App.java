package id.ac.polban.jtk;

public final class App {
    public static void main(String[] args) {
        ElevatorController
            .getInstance()
            .run();

        FloorRequestButton
            .pressed(0, 5);
            
        ElevatorController
            .getInstance()
            .terminate();
    }
}