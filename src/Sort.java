
import java.util.Scanner;

public class Sort {

    int[] arrayRandom = new int[10];
    int random = 0;
    int temp = 0;
//-------------------------------------------------------------------------------------

    public int randomValue(int random) {
        double randomDouble = Math.random() * 100D;
        random = (int) randomDouble;
        return random;
    }
//-------------------------------------------------------------------------------------

    public void bubbleSort() {
        System.out.print("โจทย์ : ");
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = randomValue(random);
            System.out.print(arrayRandom[i] + " ");
        }
        System.out.println("");

        for (int j = 0; j < arrayRandom.length; j++) {
            for (int k = 1; k < arrayRandom.length; k++) {
                if (arrayRandom[k] > arrayRandom[k - 1]) {
                    temp = arrayRandom[k];
                    arrayRandom[k] = arrayRandom[k - 1];
                    arrayRandom[k - 1] = temp;
                }
            }
        }

        for (int result : arrayRandom) {
            System.out.print(result + " ");
        }
    }
//--------------------------------------------------------------------------------------

    public void InsertionSort() {
        System.out.print("โจทย์ : ");
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = randomValue(random);
            System.out.print(arrayRandom[i] + " ");
        }
        System.out.println("");

        for (int i = 1; i < arrayRandom.length; i++) {
            int valueToSort = arrayRandom[i];
            int j = i;
            while (j > 0 && arrayRandom[j - 1] < valueToSort) {
                arrayRandom[j] = arrayRandom[j - 1];
                j--;
            }
            arrayRandom[j] = valueToSort;
        }
        for (int result : arrayRandom) {
            System.out.print(result + " ");
        }

    }
//--------------------------------------------------------------------------------------

    public void selectionSort() {
        System.out.print("โจทย์ : ");
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = randomValue(random);
            System.out.print(arrayRandom[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < arrayRandom.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arrayRandom.length; j++) {
                if (arrayRandom[j] > arrayRandom[index]) {
                    index = j;
                }
            }

            int smallerNumber = arrayRandom[index];
            arrayRandom[index] = arrayRandom[i];
            arrayRandom[i] = smallerNumber;
        }
        for (int result : arrayRandom) {
            System.out.print(result + " ");
        }
    }
//--------------------------------------------------------------------------------------

    public void mergeSort() {
        System.out.print("โจทย์ : ");
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = randomValue(random);
            System.out.print(arrayRandom[i] + " ");
        }
        System.out.println("");

        mergeSortObject();

        for (int i = arrayRandom.length - 1; i >= 0; i--) {
            System.out.print(arrayRandom[i] + " ");
        }
    }

    void mergeSortObject() {
        int[] tempArray = new int[arrayRandom.length];
        mergeSort(tempArray, 0, arrayRandom.length - 1);
    }

    void mergeSort(int[] tempArray, int lowerIndex, int upperIndex) {
        if (lowerIndex == upperIndex) {
        } else {
            int mid = (lowerIndex + upperIndex) / 2;
            mergeSort(tempArray, lowerIndex, mid);
            mergeSort(tempArray, mid + 1, upperIndex);
            merge(tempArray, lowerIndex, mid + 1, upperIndex);
        }
    }

    void merge(int[] tempArray, int lowerIndexCursor, int higerIndex, int upperIndex) {
        int tempIndex = 0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higerIndex - 1;
        int totalItems = upperIndex - lowerIndex + 1;
        while (lowerIndex <= midIndex && higerIndex <= upperIndex) {
            if (arrayRandom[lowerIndex] < arrayRandom[higerIndex]) {
                tempArray[tempIndex++] = arrayRandom[lowerIndex++];
            } else {
                tempArray[tempIndex++] = arrayRandom[higerIndex++];
            }
        }
        while (lowerIndex <= midIndex) {

            tempArray[tempIndex++] = arrayRandom[lowerIndex++];
        }
        while (higerIndex <= upperIndex) {
            tempArray[tempIndex++] = arrayRandom[higerIndex++];
        }
        System.arraycopy(tempArray, 0, arrayRandom, lowerIndexCursor, totalItems);
    }

//--------------------------------------------------------------------------------------
    public void quickSort() {
        System.out.print("โจทย์ : ");
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = randomValue(random);
            System.out.print(arrayRandom[i] + " ");
        }
        System.out.println("");

        int low = 0;
        int high = arrayRandom.length - 1;
        quickSortObjct(arrayRandom, low, high);

        for (int i = arrayRandom.length - 1; i >= 0; i--) {
            System.out.print(arrayRandom[i] + " ");
        }

    }

    void quickSortObjct(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSortObjct(arr, low, j);
        }

        if (high > i) {
            quickSortObjct(arr, i, high);
        }
    }

//--------------------------------------------------------------------------------------
    public void selectSort() {
        Scanner scan = new Scanner(System.in);
        System.out.println("กรอกได้ เฉพาะ bubbleSort,InsertionSort,selectionSort,mergeSort,quickSort");
        System.out.print("TypeSort : ");
        String typeSort = scan.nextLine();
        switch (typeSort) {
            case "bubbleSort":
                bubbleSort();
                break;
            case "InsertionSort":
                InsertionSort();
                break;
            case "selectionSort":
                selectionSort();
                break;
            case "mergeSort":
                mergeSort();
                break;
            case "quickSort":
                quickSort();
                break;
            default:
                System.out.println("ชื่อ TypeSort นี้ไม่มีในระบบกรุณากรอกใหม่");
                selectSort();
        }
        System.out.println("");
    }
    //--------------------------------------------------------------------------------------

    public void yesAndNo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("คุณจะต้องการจะ run sort ตัวอื่นอีกหรือไม่ ตอบ yes หรือ no เท่านั้น: ");
        String yasAndNo = scan.nextLine();
        if (yasAndNo.equals("yes")) {
            selectSort();
            yesAndNo();
        }
        if (yasAndNo.equals("no")) {
            System.out.println("จบการทำงาน");
        }
        if (!yasAndNo.equals("yes") && !yasAndNo.equals("no")) {
            System.out.println("ตอบได้เฉพาะ yes หรือ no เท่านั้น");
            yesAndNo();
        }
    }
//-------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.selectSort();
        sort.yesAndNo();

    }

}
