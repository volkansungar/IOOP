import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int[] array1 = new int[50];
        int[] array2 = new int[50];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number for array1:");
        int num = input.nextInt();
        int c1 = 0;
        while (num != -1) {
            array1[c1] =num;
            c1++;
            num = input.nextInt();
            }

        SortUtility.bubbleSort(array1);
        System.out.println("array1:"+Arrays.toString(array1));

        System.out.println("Enter number for array2:");
        num = input.nextInt();
        int c2 = 0;
        while (num != -1) {
            array2[c2] = num;
            c2++;
            num = input.nextInt();
            }
        SortUtility.bubbleSort(array2);
        System.out.println("array2:"+Arrays.toString(array2));

        int[] array3 = MergeUtility.merge(array1, array2, c1, c2);
        System.out.println(Arrays.toString(array3));
    }
}

class SortUtility {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

class MergeUtility {
    public static int[] merge(int[] array1, int[] array2, int c1, int c2) {
        int len = c1 + c2;
        int c = 0;
        int[] temp = new int[len];
        int[] temp2 = new int[len];
        System.arraycopy(array1, array1.length-c1, temp, 0, c1);
        System.arraycopy(array2, array2.length-c2, temp, c1, c2);
        SortUtility.bubbleSort(temp);
        for (int i = 1; i < len; i++) {
            if (temp[i-1] != temp[i]) {
                temp2[c] = temp[i-1];
                c++;
            }
        }
        if (temp2[c] == 0) {temp2[c] = temp[len-1];}
        int[] array3 = new int[c+1];
        System.arraycopy(temp2, 0, array3, 0, c+1);
        return array3;
    }
}


/*class RandomArray {
    public static int[] randomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }
}**/
