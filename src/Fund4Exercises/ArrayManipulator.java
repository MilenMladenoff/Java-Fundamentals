package Fund4Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(commandLine[1]);
                    if (0 <= index && index < arr.length) {
                        exchange(arr, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "max":
                    if (commandLine[1].equals("even")) {
                        printMaxEven(arr);
                    } else {
                        printMaxOdd(arr);
                    }
                    break;

                case "min":
                    if (commandLine[1].equals("even")) {
                        printMinEven(arr);
                    } else {
                        printMinOdd(arr);
                    }
                    break;

                case "first":
                    int count = Integer.parseInt(commandLine[1]);
                    if (count > arr.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (commandLine[2].equals("even")) {
                            printFirstCountEvens(arr, count);
                        } else {
                            printFirstCountOdds(arr, count);
                        }
                    }
                    break;

                case "last":
                    count = Integer.parseInt(commandLine[1]);
                    if (count > arr.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (commandLine[2].equals("even")) {
                            printLastCountEvens(arr, count);
                        } else {
                            printLastCountOdds(arr, count);
                        }
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void printLastCountOdds(int[] arr, int count) {
        int[] tempArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0 && count > 0) {
                tempArr[i] = arr[i];
                count--;
            } else {
                tempArr[i] = -1;
            }
        }
        printArr(tempArr);
    }

    private static void printLastCountEvens(int[] arr, int count) {
        int[] tempArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0 && count > 0) {
                tempArr[i] = arr[i];
                count--;
            } else {
                tempArr[i] = -1;
            }
        }
        printArr(tempArr);
    }

    private static void printFirstCountOdds(int[] arr, int count) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && count > 0) {
                tempArr[i] = arr[i];
                count--;
            } else {
                tempArr[i] = -1;
            }
        }
        printArr(tempArr);
    }

    private static void printFirstCountEvens(int[] arr, int count) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && count > 0) {
                tempArr[i] = arr[i];
                count--;
            } else {
                tempArr[i] = -1;
            }
        }
        printArr(tempArr);
    }

    private static void printArr(int[] arr) {
        System.out.print("[");
        boolean elementIsPrinted = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                if (elementIsPrinted) {
                    System.out.print(arr[i]);
                    elementIsPrinted = false;
                } else {
                    System.out.print(", " + arr[i]);
                }
            }
        }

        System.out.println("]");
    }

    private static void printMinOdd(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int rightmostIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minNum && arr[i] % 2 != 0) {
                minNum = arr[i];
                rightmostIndex = i;
            }
        }

        if (rightmostIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(rightmostIndex);
        }
    }

    private static void printMinEven(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int rightmostIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minNum && arr[i] % 2 == 0) {
                minNum = arr[i];
                rightmostIndex = i;
            }
        }

        if (rightmostIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(rightmostIndex);
        }
    }

    private static void printMaxOdd(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        int rightmostIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum && arr[i] % 2 != 0) {
                maxNum = arr[i];
                rightmostIndex = i;
            }
        }

        if (rightmostIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(rightmostIndex);
        }
    }

    private static void printMaxEven(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        int rightmostIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum && arr[i] % 2 == 0) {
                maxNum = arr[i];
                rightmostIndex = i;
            }
        }

        if (rightmostIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(rightmostIndex);
        }
    }

    private static void exchange(int[] arr, int index) {

        int[] firstHalf = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            firstHalf[i] = arr[i];
        }

        int[] secondHalf = new int[arr.length - index - 1];
        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = arr[index + 1 + i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < secondHalf.length) {
                arr[i] = secondHalf[i];
            } else {
                arr[i] = firstHalf[i - secondHalf.length];
            }
        }
    }
}
