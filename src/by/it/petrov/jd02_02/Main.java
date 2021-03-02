package by.it.petrov.jd02_02;

public class Main {

    public static int currentVisitorsCountInTheShop = 0;

    public static Integer determineNumberOfCashiersNeeded(Integer currentCustomersInDeque) {
        if (Deque.currentCustomersInDeque() == 0) {
            return 0;
        } else if (Deque.currentCustomersInDeque() >= 21) {
            return 5;
        } else return (Deque.currentCustomersInDeque() / 5) + 1;
    }

    public static void main(String[] args) throws InterruptedException {

        int totalVisitorsCount = 0;
        int speedCoefficient = 100;

        Timer timer = new Timer(120, speedCoefficient);
        Deque paymentsDeque = new Deque();
        Integer secondsOfMinutePassed = Timer.getSecondsPassed();

        while (timer.isAlive()) {

            if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop < Timer.getSecondsPassed() + 10) {
                for (int i = 0; i < 1; i++) {
                    Buyer buyer = new Buyer(("Visitor number " + (totalVisitorsCount + 1)));
                    totalVisitorsCount++;
                    Thread.sleep(100 / Timer.getSpeedCoefficient());
                }
            } else if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop >= Timer.getSecondsPassed() + 10) {
                System.out.println("Too many customers ... (max: " + (Timer.getSecondsPassed() + 10) + ") (current: "
                        + currentVisitorsCountInTheShop);
                Thread.sleep(2000 / Timer.getSpeedCoefficient());
            } else if (Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop <= 40 + (30 - Timer.getSecondsPassed())) {
                for (int i = 0; i < 1; i++) {
                    Buyer buyer = new Buyer(("Visitor number " + (totalVisitorsCount + 1)));
                    totalVisitorsCount++;
                    Thread.sleep(100 / Timer.getSpeedCoefficient());
                }
            } else if (Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop > 40 + (30 - Timer.getSecondsPassed())) {
                System.out.println("Too many customers ... (max: " + (Timer.getSecondsPassed() + 10) +
                        ") (current: " + currentVisitorsCountInTheShop);
                Thread.sleep(2000 / Timer.getSpeedCoefficient());
            }

            Integer numberOfCashiersNeeded = determineNumberOfCashiersNeeded(currentVisitorsCountInTheShop);
            Integer currentNumberOfCashiers = Cashier.getCurrentNumberOfCashiers();
            if (currentNumberOfCashiers < numberOfCashiersNeeded) {
                System.out.println("----------------------------");
                System.out.println("Current cashiers count: " + currentNumberOfCashiers);
                System.out.println("Cashiers needed:        " + numberOfCashiersNeeded);
                System.out.println("Total queue size:       " + Deque.currentCustomersInDeque());
                System.out.println("----------------------------");
                for (int i = 0; i < numberOfCashiersNeeded - Cashier.getCurrentNumberOfCashiers(); i++) {
                    Cashier cashier = new Cashier("Cashier #"
                            + (Cashier.getCurrentNumberOfCashiers() + 1), speedCoefficient, timer);
                    Thread.sleep(1000 / Timer.getSpeedCoefficient());
                }
            }
        }
    }
}

