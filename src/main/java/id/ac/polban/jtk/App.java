package id.ac.polban.jtk;

public final class App {
    /**
     * @throws InterruptedException
     * 
     */
    public static void main(String[] args) throws InterruptedException {
        ElevatorController
            .getInstance()
            .run();



        ElevatorController
            .getInstance()
            .terminate();
    }
}