package by.it.abeseda.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable{

    private final int numberDesk;
    private int time1 = Generator.GeneratorRandom(2000, 5000);


    public Cashier(int numberDesk) {
        this.numberDesk=numberDesk;
    }

    @Override
    public String toString() {
        return "Cashier number=" + this.numberDesk;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()){
            System.out.println("Проверка работает ли");
            //возвращает с удалением элемент из начала очереди.
            //если очередь пуста, возвращает значение null
            Buyer buyer=OneQueueBuyers.poll();
            if (Objects.nonNull(buyer)){
                System.out.println(this+" started service for "+buyer);
                Generator.timeout(time1);
                synchronized (buyer.getMonitorWaiting()){
                    buyer.setWaitFlag(false);//Вот мы меняем флаг для байера!
                    buyer.notify();//разобраться! не понимаю последовательность действий!
                    //ОЧЕНЬ ВАЖНО!
                    //notify()возобновляет исполнение потока из которого был вызван wait()
                    //т.е. данный объект отдает монитор другому методу!
                }
                System.out.println(this+" finished service for "+buyer);
            } else {
                //нет покупателей в очереди, объект buyerPoll пусто!
                // тут подумайте как сделать так чтобы кассир ожидал (но не завис в конце работы)

                Thread.onSpinWait();
                //Вызывается с целью обозначить исполнение текущего потока в цикле ожидания, допуская
                //оптимизацию на стадии выполнения (внедрен в версии JDK 9)
            }
        }

        System.out.println(this+"is closed.");

    }
}

