package by.it.abeseda.jd02_02;

interface BuyerDoInMarket {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goToOneOfQueue();  // покупатель идет в одну из 2 касс из ОДНОЙ очереди! очередь общая!

    void goOut();     //отправился на выход(мгновенно)
}
