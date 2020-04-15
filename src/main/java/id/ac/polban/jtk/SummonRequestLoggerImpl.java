package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

import id.ac.polban.jtk.ElevatorController.Request;

/**
 * @author RomaUlina
 * @author Andhika
 */
class SummonRequestLoggerImpl implements SummonRequestLogger {
    private final ElevatorController elevatorController;

    private DoorOperator doorOperator;  

    private SummonRequestLoggerImpl(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }
    
    public void pressed(final int floorNumber, final Direction direction) {
        // if (floorNumber==floorNumberCab) {
        //     doorOperator.doorOpened();
        // } 
            
        // Add request to queue
        this.elevatorController
            .getRequestQueue()
            .add(new SummonRequest(floorNumber, direction));
        
        //show direction
        // void ShowDirection(Direction direction){
        //     if(direction.getValue() == Direction.UP.getValue()){
            
            
        //     }else if(direction.getValue() == Direction.UP.getValue()){
        //      DirectionDown = LightStatus.OFF;
        //         System.out.println("The summon button light is " + DirectionDown);
        //     }
        // }

                            
            // Turn Light of
            // elevatorController
            // .getCabController()
            // .getSummonRequestButton(cabID,direction, floorNumber)
            // .turnLightOff();
            
            // doorOperator.doorOpened();
        //  elevatorController
    //      .getRequestQueue()
    //      .remove??(SumonRequest(cabID,direction, floorNumber));
        // }
    }
    
    /**
    * @author RomaUlina
    */
    public void released(final int floorNumber, final Direction direction){
        // int floorNumberCab = ElevatorController.getCabController().getCabNavigator(cabID).getFloorNumber();
        // if((floorNumber==floorNumberCab) && (doorOperator.getDoorStatus()==DoorOperator.DoorStatus.OPENED)){
        //     elevatorController.
        //     TurnLightOff(direction);
        //     DoorTimer doorTimer = new DoorTimer();
        //     doorTimer.StartTimer();
        //     doorOperator.doorClosed();
        //     //A summon button sends a signal to the controller indicating that it was released.
        // }
    }
    
    public static SummonRequestLogger createInstance(ElevatorController elevatorController) {
        return (SummonRequestLogger) Proxy.newProxyInstance(SummonRequestLogger.class.getClassLoader(),
                                                            new Class[] {SummonRequestLogger.class},
                                                            new SignalModule(new SummonRequestLoggerImpl(elevatorController)));
    }

    public static class SummonRequest extends Request {
        private int floorNumber;
        
        private Direction direction;

        public SummonRequest(int floorNumber, Direction direction) {
            super();

            this.floorNumber = floorNumber;
            
            this.direction = direction;

            // Turn the button light on
            this.elevatorController
                .getCabController()
                .getSummonRequestButton(cabID,direction, floorNumber)
                .turnLightOn();
        }

        @Override
        public int getCabID() {
            //TODO:
            return 0;
        }

        @Override
        public int getFloorNumber() {
            return this.floorNumber;
        }
        
        @Override
        public void onDelete() {
            // Turn Light off
            elevatorController
            .getCabController()
            .getSummonRequestButton(cabID,direction, floorNumber)
            .turnLightOff();
        }
    }    
}