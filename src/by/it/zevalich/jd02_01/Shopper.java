package by.it.zevalich.jd02_01;

public class Shopper extends Thread implements IShopper, IUseBasket{
    int numberOfShopper;
    
    public Shopper(int numberOfShopper){
        this.numberOfShopper = numberOfShopper;
        this.setName("Покупатель № " + numberOfShopper + " ");
        start();
    }


    public void run(){
        enteredTheStore();
        choseAProduct();
        goToOut();
    }

    public String toString(){return this.getName();}

    @Override
    public void enteredTheStore() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void choseAProduct() {
        try{
            int pause = Rndm.fromTo(500,2000);
            Thread.sleep(pause);
        }catch (InterruptedException e){
            System.out.println(this + "некорректное завершения ожидания");
        }
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBasket() {

    }

    @Override
    public void putTheProductsInTheBasket() {

    }
}
