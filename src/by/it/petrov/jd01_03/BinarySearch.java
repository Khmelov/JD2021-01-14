package by.it.petrov.jd01_03;

public class BinarySearch {

    public static int search(double[] arr, double number){
        if (arr.length % 2 == 0){
            int leftArray = arr.length / 2;
        } else {
            int leftArray = (arr.length / 2) + 1;
        }

        int rightArray = arr.length / 2;
        return 1;
    }

    public static void main(String[] args) {
        double[] arr = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double number = 5;
        int i_searchedNumber = search(arr, 2);
        System.out.println(i_searchedNumber);

    }

}
