
import java.util.Date;
import java.util.Scanner;

public class Sort {

    int[] arrayRandom = new int[10000];
    int[] arrayRandomAffter = new int[10000];
    int random = 0;
    int temp = 0;

//-------------------------------------------------------------------------------------
    public int randomValue(int random) {
        double randomDouble = Math.random() * 100000D;
        random = (int) randomDouble;
        return random;
    }
//-------------------------------------------------------------------------------------

    public void bubbleSort() {

        long start = System.currentTimeMillis();

        Sort sort = new Sort();

        System.out.print("โจทย์ : ");
        if (arrayRandom[0] == 0) {
            for (int i = 0; i < arrayRandom.length; i++) {
                arrayRandom[i] = randomValue(random);
                arrayRandomAffter[i] = arrayRandom[i];
                System.out.print(arrayRandom[i] + " ");
            }
        } else {
            for (int i = 0; i < arrayRandomAffter.length; i++) {
                arrayRandom[i] = arrayRandomAffter[i];
                System.out.print(arrayRandom[i] + " ");
            }
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
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("เวลาที่รัน: " + (end - start));
    }
//--------------------------------------------------------------------------------------

    public void InsertionSort() {

        long start = System.currentTimeMillis();

        System.out.print("โจทย์ : ");
        if (arrayRandom[0] == 0) {
            for (int i = 0; i < arrayRandom.length; i++) {
                arrayRandom[i] = randomValue(random);
                arrayRandomAffter[i] = arrayRandom[i];
                System.out.print(arrayRandom[i] + " ");
            }
        } else {
            for (int i = 0; i < arrayRandomAffter.length; i++) {
                arrayRandom[i] = arrayRandomAffter[i];
                System.out.print(arrayRandom[i] + " ");
            }
        }
        System.out.println("");

        for (int i = 1; i < arrayRandom.length; i++) {
            int valueToSort = arrayRandom[i];
            int j = i;
            while (j > 0 && arrayRandom[j - 1] < valueToSort) {
                arrayRandom[j] = arrayRandom[j - 1];
                j--;
            }
            arrayRandom[j] = valueToSort; // อย่าคิดไปรวกะใน loopwhile
        }
        for (int result : arrayRandom) {
            System.out.print(result + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("เวลาที่รัน: " + (end - start));
    }
//--------------------------------------------------------------------------------------

    public void selectionSort() {

        long start = System.currentTimeMillis();

        System.out.print("โจทย์ : ");
        if (arrayRandom[0] == 0) {
            for (int i = 0; i < arrayRandom.length; i++) {
                arrayRandom[i] = randomValue(random);
                arrayRandomAffter[i] = arrayRandom[i];
                System.out.print(arrayRandom[i] + " ");
            }
        } else {
            for (int i = 0; i < arrayRandomAffter.length; i++) {
                arrayRandom[i] = arrayRandomAffter[i];
                System.out.print(arrayRandom[i] + " ");
            }
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
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("เวลาที่รัน: " + (end - start));

    }
//--------------------------------------------------------------------------------------

    public void mergeSort() {

        long start = System.currentTimeMillis();

        System.out.print("โจทย์ : ");
        if (arrayRandom[0] == 0) {
            for (int i = 0; i < arrayRandom.length; i++) {
                arrayRandom[i] = randomValue(random);
                arrayRandomAffter[i] = arrayRandom[i];
                System.out.print(arrayRandom[i] + " ");
            }
        } else {
            for (int i = 0; i < arrayRandomAffter.length; i++) {
                arrayRandom[i] = arrayRandomAffter[i];
                System.out.print(arrayRandom[i] + " ");
            }
        }
        System.out.println("");

        mergeSortObject();

        for (int i = arrayRandom.length - 1; i >= 0; i--) {
            System.out.print(arrayRandom[i] + " ");
        }

        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("เวลาที่รัน: " + (end - start));
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

        long start = System.currentTimeMillis();

        System.out.print("โจทย์ : ");
        if (arrayRandom[0] == 0) {
            for (int i = 0; i < arrayRandom.length; i++) {
                arrayRandom[i] = randomValue(random);
                arrayRandomAffter[i] = arrayRandom[i];
                System.out.print(arrayRandom[i] + " ");
            }
        } else {
            for (int i = 0; i < arrayRandomAffter.length; i++) {
                arrayRandom[i] = arrayRandomAffter[i];
                System.out.print(arrayRandom[i] + " ");
            }
        }
        System.out.println("");

        int low = 0;
        int high = arrayRandom.length - 1;
        quickSortObjct(arrayRandom, low, high);

        for (int i = arrayRandom.length - 1; i >= 0; i--) {
            System.out.print(arrayRandom[i] + " ");
        }

        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("เวลาที่รัน: " + (end - start));

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

//ก่อนอื่น ต้องเข้าใจก่อนว่า โปรแกรมเดียวกัน รันด้วย input ตัวเดียวกัน ไม่จำเป็นต้องรันได้เวลาเท่ากันเสมอไปครับ
//คร่าวๆ อาจจะได้ เช่น ประมาณ 5-6 วินาทีเหมือนกัน แต่ถ้าจะเอาละเอียดเป็น milli sec หรือ nano sec นี่ไม่มีทางเลยครับ
//
//ที่มันไม่เท่ากันเพราะว่า การทำงานหลายๆ อย่างของคอมพิวเตอร์มันกำหนดเวลาตายตัวแน่นนอนไม่ได้
//เช่น ถ้าเครื่องมี harddisk การอ่านข้อมูลตำแหน่งเดียวกัน จากไฟล์เดียวกัน 2 ครั้ง ก็อาจใช้เวลาไม่เท่ากันแล้ว เพราะมันทำงานด้วยการหมุนของ disk และการเลื่อนของหัวอ่าน ซึ่งแล้วแต่การอ่านแต่ละครั้ง ว่าต้องหมุนหรือเลื่อนมากน้อยแค่ไหนถึงจะอ่านข้อมูลได้ครบ
//นอกจากนั้น บนเครื่องไม่ได้มีโปรแกรมของคุณคนเดียวที่รันอยู่ มันยังมี OS มี service ที่รันเป็น background มี system interrupt ที่คอยแย่ง CPU จากโปรแกรมคุณมาทำงานอีก
//
//คุณคิดเอาง่ายๆ นะครับ ว่าคุณลอง boot Windows ขึ้นมาบนเครื่องเดียวกัน ลองทำ 2 ครั้งแล้วจับเวลา ก็ได้เวลาไม่เท่ากันครับ (เอาหน่วยวินาทีก็พอ)
//
//เรื่องนี้ มันเป็นไปไม่ได้ครับ
//ถ้าจะหาว่าโปรแกรมใช้เวลาทำงานเท่าไหร่ ส่วนใหญ่ เค้าจะเก็บข้อมูลหลายๆ ครั้ง แล้วใช้ข้อมูลทางสถิติแทนครับ เช่น รันแล้วจับเวลา 30 ครั้ง แล้วหาค่าเฉลี่ย หรือหาค่า percentile ที่ 95 ก็ว่ากันไป
