package id.ac.polban.jtk;

public final class App {
    public static class TestRequest extends ElevatorController.Request {

        @Override
        public Void call() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }

    }

    /**
     * @throws InterruptedException
     * 
     */
    public static void main(String[] args) throws InterruptedException {
        ElevatorController
            .getInstance()
            .run();
    }
}
