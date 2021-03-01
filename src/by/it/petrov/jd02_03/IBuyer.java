package by.it.petrov.jd02_03;

public interface IBuyer {
    void enteredToMarket() throws InterruptedException; //вошёл в магазин (мгновенно)
    void chooseGoods() throws InterruptedException; //выбрал товар (от 0,5 до 2 секунд)
    void layOutGoodsToCashier(); // выложить покупки кассиру (и ждать чека (от 2 до 5 секунд))
   // void takeBill(); // получить чек (мгновенно)
    void goOut(); // отправился на выход (мгновенно)
}