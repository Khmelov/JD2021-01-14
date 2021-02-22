package by.it.petrov.jd02_01;

public interface IBuyer {
    void enteredToMarket() throws InterruptedException; //вошёл в магазин (мгновенно)
    void chooseGoods() throws InterruptedException; //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); // отправился на выход (мгновенно)
}
