package by.it.lapushkin.jd01_05;

import java.util.Arrays;

public class InOut {
    static double[] getArray(String line) {
        String[] stringArray = line.trim().split(" ");
        double[] intArray = new double[stringArray.length];
        for (int i = 0, stringArrayLength = stringArray.length; i < stringArrayLength; i++) {
            intArray[i] = Double.parseDouble(stringArray[i]);
        }

        return intArray;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.5f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || (array.length - 1 == i)) {
                System.out.println();
            }
        }

    }

    static void printArrayC3(int[] array, String name, int wayIndex) {


        String equal = "\u2550".repeat(15);

        if (wayIndex == 1) {
            System.out.println("Array " + name + " <index to rows>");
            System.out.println();
            int columnCount = 5;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    System.out.printf("\u2554%s\u2566%s\u2566%s\u2566%s\u2566%s\u2557\n\u2551", equal, equal, equal, equal, equal);
                }
                if (i % columnCount == 0 && i != 0) {
                    System.out.printf("\n\u2560%s\u256C%s\u256C%s\u256C%s\u256C%s\u2563\n\u2551", equal, equal, equal, equal, equal);
                }

                System.out.printf("%3s [% -3d ]=%-4d\u2551", name, i, array[i]);

                if (i == array.length - 1) {
                    int count = 0;

                    for (int k = i + 1; k % columnCount != 0; k++) {
                        count++;
                    }

                    if (count != 0) {
                        for (int j = 0; j < count; j++) {
                            System.out.printf("%16s", "\u2551");
                        }
                    }
                }

                if (i == array.length - 1) {
                    System.out.printf("\n\u255A%s\u2569%s\u2569%s\u2569%s\u2569%s\u255D\n\n", equal, equal, equal, equal, equal);
                }
            }
        } else if (wayIndex == 2) {
            System.out.println("Array " + name + " <index to columns>");
            System.out.println();

            int columnCount = 2;
            for (int i = 5; i > 2; i--) {
                if (array.length % i == 0) {
                    columnCount = i;
                    break;
                }
            }
            int rowCount = (int) Math.ceil((double) array.length / columnCount);
            if (rowCount == array.length * 2) {
                rowCount = rowCount - 1;
            }
            int[] index = new int[300];
            Arrays.fill(index, -1);


            for (int i = 0, k = 0, y = 1, h = 0, l = 0; i < 300; i += rowCount, k++, h++) {
                boolean find = false;
                for (int value : index) {
                    if (i == value) {
                        find = true;
                        break;
                    }
                }

                if (k >= rowCount) {
                    k = 0;
                    i = y++;
                }

                if (!find && i < array.length) {
                    String delimiterUP = (equal + "\u2566").repeat(columnCount - 1);
                    String delimiterCenter = (equal + "\u256C").repeat(columnCount - 1);
                    String delimiterBottom = (equal + "\u2569").repeat(columnCount - 1);

                    if (l == 0) {
                        System.out.printf("\u2554%s%s\u2557\n\u2551", delimiterUP, equal);
                    }


                    if (l % columnCount == 0 && l != 0) {
                        System.out.printf("\n\u2560%s%s\u2563\n\u2551", delimiterCenter, equal);
                    }

                    System.out.printf("%3s [% -3d ]=%-4d\u2551", name, i, array[i]);


                    if (l == array.length - 1 && l % columnCount == 0) {
                        int count = 0;

                        for (int a = i + 1; a % columnCount != 0; a++) {
                            count++;
                        }

                        if (count != 0) {
                            for (int j = 0; j < count; j++) {
                                System.out.printf("%16s", "\u2551");
                            }
                        }
                    }


                    if (l == array.length - 1) {
                        System.out.printf("\n\u255A%s%s\u255D\n\n", delimiterBottom, equal);
                    }
                    l++;
                }
                if (l == array.length) {
                    break;
                }

                index[h] = i;

            }
        }
    }
}
























