package by.it.abeseda.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class  OneQueueBuyers {

    //2 кассы, значит будет 2 очереди, значит будет 2 Cashier
    private  static final Deque<Buyer> ONE_BUYERS_DEQUE=new ArrayDeque<>();

    //synchronized this. это тоже самое толькое медленнее в байт коде
    //монитором является this, а именно экземпляр класса OneQueueBuyers
    //никто не может воспользоваться данным методом пока add держит монитор
    //а именно пока выполняется метод для экземпляра класса
    //добавляет элемент buyer в конец очереди
    static synchronized void add(Buyer buyer){
        ONE_BUYERS_DEQUE.addLast(buyer);
    }

    //E pollFirst(): возвращает с удалением элемент из начала очереди.
    //если очередь пуста, возвращает значение null
    static synchronized Buyer poll(){
        return ONE_BUYERS_DEQUE.pollFirst();
    }
}




