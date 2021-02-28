package by.it.lapushkin.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

public class Score {

    private  Monitoring monitoring;
    private String name;
    private AtomicBoolean stateDoor;
    private AtomicBoolean stateScore;

    public Score(String name,Monitoring monitoring){
        this.monitoring = monitoring;
        this.name = name;
    }

    public void jobScore(int exValueCustomers) {

        for (int i = 0; i < exValueCustomers; i++) {
            boolean oldCustomers = i % 4 == 0;
            inputCustomers(monitoring.getNumberCustomer(), oldCustomers);
        }
    }

    private void inputCustomers(int number, boolean oldCustomer) {
        if (stateDoor.get()) {
            new Person(number, oldCustomer);
        }
    }


    public void openScore() {
        stateScore.compareAndSet(State.ClOSED.getState(), State.OPEN.getState());
        //System.out.println("Score is opened!");
    }

    public void closeScore() {
        stateScore.compareAndSet(State.OPEN.getState(), State.ClOSED.getState());
        //System.out.println("Score is closed!");
    }

    public void openDoor() {
        stateDoor.compareAndSet(State.ClOSED.getState(), State.OPEN.getState());
        //System.out.println("Door is opened!");
    }

    public void closeDoor() {
        stateDoor.compareAndSet(State.OPEN.getState(), State.ClOSED.getState());
        //System.out.println("Door is closed!");
    }

    public AtomicBoolean isScore() {
        return stateScore;
    }

    public AtomicBoolean isDoor() {
        return stateDoor;
    }

    public enum State {
        OPEN(true),
        ClOSED(false);
        private final boolean state;

        State(boolean state) {
            this.state = state;
        }

        public boolean getState() {
            return state;
        }
    }
}
