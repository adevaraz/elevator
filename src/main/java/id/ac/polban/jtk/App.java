package id.ac.polban.jtk;

public final class App {
    public static void main(String[] args) {
        try {
            ElevatorController
                .getInstance()
                .run();

            FloorRequestButton
                .pressed(0, 5);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(1, 2);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(0, 2);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(1, 4);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(1, 2);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(0, 4);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(0, 1);

            Thread.sleep(500);

            FloorRequestButton
                .pressed(1, 5);


            // ElevatorController
            //     .getInstance()
            //     .terminate();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}