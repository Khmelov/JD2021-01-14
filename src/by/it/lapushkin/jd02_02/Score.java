package by.it.lapushkin.jd02_02;

public class Score {

    private static boolean stateDoor;
    private static boolean stateScore;

    private Score() {
    }

    public static void jobScore(int exValueCustomers) {
        if (!Monitoring.fullScore()) {
            for (int i = 0; i < exValueCustomers; i++) {
                boolean oldCustomers = i % 4 == 0;
                inputCustomers(Monitoring.getNumberCustomer(), oldCustomers);
            }
        }
    }

    private static void inputCustomers(int number, boolean oldCustomer) {
        if (stateDoor) {
            new Person(number, oldCustomer);
        } else {
            System.out.println("The doors are closed, i can't let clients in");
        }
    }

    public static void openScore() {
        stateScore = State.OPEN.getState();
        System.out.println("Score is opened!");
    }

    public static void closeScore() {
        stateScore = State.ClOSED.getState();
        System.out.println("Score is closed!");
    }

    public static void openDoorScore() {
        stateDoor = State.OPEN.getState();
        System.out.println("Door is opened!");
    }

    public static void closeDoorScore() {
        stateDoor = State.ClOSED.getState();
        System.out.println("Door is closed!");
    }

    public static boolean isScoreOpen() {
        return stateScore;
    }

    public static boolean isDoorOpen() {
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
