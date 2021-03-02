package by.it.shebeko.jd02_03;

public class Cashier  implements Runnable{


    private String name;
    private  boolean cash = false;
    private  int number = 0;

    public Cashier (int number) {
        this.name = "\tCashier №" + number;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " is closed");
        while (!Supervisor.marketIsClosed()){
            Buyers buyers = QueueBuyers.extract();
            if (buyers !=null){
                System.out.printf("%s started service for %s\n", this, buyers);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                System.out.printf("%s finished service for %s\n", this, buyers);
                synchronized (buyers){
                    buyers.notify();
                }
            } else {
                Thread.yield();
            }
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
