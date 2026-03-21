import java.util.Arrays;
import java.util.Random;

public class SelectionSorting {
    public static void main(String[] args) {

        int[] numbers = new int[5];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(250000);
        }

        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("After Sorting");
        System.out.println(Arrays.toString(numbers));


    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            int min = numbers[i];
            int indexMin = i;
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                }
            }
            swap(numbers, i, indexMin);
        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
