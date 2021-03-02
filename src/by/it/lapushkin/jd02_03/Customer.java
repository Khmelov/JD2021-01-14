package by.it.lapushkin.jd02_03;

public interface Customer {
    void enterToStore();
    void selectProduct();
    void getOutTheStore();
    void goToQueue() throws InterruptedException;
}
