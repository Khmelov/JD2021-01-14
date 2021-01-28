package by.it.petrov.jd01_02;

public class TaskCtesting {
    public static void main(String[] args) {
        int[] arr = {2, -5, -1, -1, -2, -3, -5, 2, 9};
        int quantityOfPN = 0;
        int i_first_PN = -1;
        int i_second_PN = -1;
        int sum_of_two_numbers = 0;
        int check_for_positive_numbers = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0){
                check_for_positive_numbers += 1;
            }
        }

        if(check_for_positive_numbers < 2){
            System.out.println("Not enough positive number for computing ...");
        }

        if(check_for_positive_numbers == 0){
            System.out.println("There are no any possible numbers in the row ...");
        }

        if (check_for_positive_numbers >= 2){
            while (quantityOfPN < 2){
                while(i_first_PN < 0){

                    for (int i = 0; i < arr.length; i++) {
                        if(arr[i] >= 0){
                            i_first_PN = i;
                            quantityOfPN += 1;
                            break;
                        }
                    }
                }
                while(i_second_PN < 0){
                    for (int i = i_first_PN + 1; i < arr.length; i++) {
                        if(arr[i] >= 0){
                            i_second_PN = i;
                            quantityOfPN += 1;
                            break;
                        }
                    }
                }

                System.out.println("i of first number is " + i_first_PN + " i of second number is " + i_second_PN);
            }
            if (i_second_PN - i_first_PN == 1){
                sum_of_two_numbers = 0;
                System.out.println("The sum equals to zero due to difference between 1st and 2nd positive element equals to 0");
            }
            if (i_second_PN - i_first_PN > 1){
                for (int i = i_first_PN + 1; i < i_second_PN; i++) {
                    sum_of_two_numbers += arr[i];
                }
            }
        }
        System.out.println(sum_of_two_numbers);
    }
}
