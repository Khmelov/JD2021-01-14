package by.it.petrov.jd01_04;

public class Recursion {

    public static int[][] arraysConcatenation(int[][] array, int left, int right){
        int[][] concatenatedArray = new int [array.length / 2][array[0].length * 2];
        for (int i = 0, j = 0; i < concatenatedArray.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2}, // {1, 2, 3, 4}
                {3, 4}, // {5, 6, 7, 8}
                {5, 6},
                {7, 8}
        };
        int numberOfComponents = array.length;
        System.out.println(numberOfComponents);
    }

}
