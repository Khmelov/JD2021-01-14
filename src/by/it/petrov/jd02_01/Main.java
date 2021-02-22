package by.it.petrov.jd02_01;

public class Main {

    public static int currentVisitorsCountInTheShop = 0;

    public static void main(String[] args) throws InterruptedException {

        int totalVisitorsCount = 0;

        int speedCoefficient = 100;

        Timer timer = new Timer(120, speedCoefficient);


        int rndMultiplicator = 2;

        while (timer.isAlive()) {
            System.out.println(timer.isAlive());

            if(Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop < Timer.getSecondsPassed() + 10){
                rndMultiplicator +=1;
                System.out.println("Too little customers ... Open new doors! " +
                        "Maximum customers to enter count is " + rndMultiplicator + "(time " + Timer.getSecondsPassed() + ")");
            }
            if (Timer.getSecondsPassed() < 30 && currentVisitorsCountInTheShop >= Timer.getSecondsPassed() + 10 && rndMultiplicator != 0){
                rndMultiplicator -= 1;
                System.out.println("Too MANY customers ! Close the doors! " +
                        "Maximum customers to enter count is " + rndMultiplicator + "(time " + Timer.getSecondsPassed() + ")");
                Thread.sleep(1000 / Timer.getSpeedCoefficient());
            }
            if(Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop <= 40 + (30 - Timer.getSecondsPassed())){
                rndMultiplicator +=1;
                System.out.println("Too little customers ... Open new doors! " +
                        "Maximum customers to enter count is " + rndMultiplicator);
            }
            if(Timer.getSecondsPassed() >= 30 && currentVisitorsCountInTheShop > 40 + (30 - Timer.getSecondsPassed())){
                System.out.println("Too MANY customers ! Close the doors! " +
                        "Maximum customers to enter count is " + rndMultiplicator + "(time " + Timer.getSecondsPassed() + ")");
                Thread.sleep(1000 / Timer.getSpeedCoefficient());
            }

            int rndNumOfBuyersPerSec = (int) Math.round(Math.random() * rndMultiplicator);
            if (rndNumOfBuyersPerSec == 1) {
                System.out.println("NEW VISITOR IS COMING...");
            }
            if (rndNumOfBuyersPerSec >= 2) {
                System.out.println("NEW VISITORS ARE COMING. " + rndNumOfBuyersPerSec + " have come at the same time");
            }
            for (int i = 0; i < rndNumOfBuyersPerSec; i++) {
                Buyer buyer = new Buyer(("Visitor number " + (totalVisitorsCount + 1)));
                totalVisitorsCount++;
            }
            Thread.sleep(1000 / Timer.getSpeedCoefficient());
        }
    }
}

