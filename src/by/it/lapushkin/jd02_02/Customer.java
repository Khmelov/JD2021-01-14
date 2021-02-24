package by.it.lapushkin.jd02_02;

public interface Customer {
    void enterToStore();
    void selectProduct();
    void getOutTheStore();
    void goToQueue() throws InterruptedException;
}
