package by.it.lapushkin.jd02_03;

public class Score {

    private static boolean stateDoor;
    private static boolean stateScore;

    private Score() {
    }

    public static void jobScore(int exValueCustomers) {

        for (int i = 0; i < exValueCustomers; i++) {
            boolean oldCustomers = i % 4 == 0;
            inputCustomers(Monitoring.getNumberCustomer(), oldCustomers);
        }
    }

    private static void inputCustomers(int number, boolean oldCustomer) {
        if (stateDoor) {
            new Person(number, oldCustomer);
        }
    }

    public static synchronized void openScore() {
        stateScore = State.OPEN.getState();
        System.out.println("Score is opened!");
    }

    public static synchronized void closeScore() {
        stateScore = State.ClOSED.getState();
        System.out.println("Score is closed!");
    }

    public static synchronized void openDoor() {
        stateDoor = State.OPEN.getState();
        System.out.println("Door is opened!");
    }

    public static synchronized void closeDoor() {
        stateDoor = State.ClOSED.getState();
        System.out.println("Door is closed!");
    }

    public static synchronized boolean isScore() {
        return stateScore;
    }

    public static synchronized boolean isDoor() {
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
