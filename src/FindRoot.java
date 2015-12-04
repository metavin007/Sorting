
import java.util.ArrayList;
import static java.util.Collections.max;
import java.util.Scanner;

public class FindRoot {

    public void InputData(float root, float epsilon) {

        ArrayList<Float> ansxPOWER = new ArrayList<>();
        ArrayList<Float> ansSum = new ArrayList<>();

        float a[] = new float[100];
        float b[] = new float[100];
        float SUMabDIV2[] = new float[100];
        float xPOWER2SUBn[] = new float[100];

        a[0] = 0;
        b[0] = root;

        SUMabDIV2[0] = (a[0] + b[0]) / 2;
        xPOWER2SUBn[0] = SUMabDIV2[0] * SUMabDIV2[0] - root;

        for (int i = 0; i < 100; i++) {
            if (i > 0) {
                if (xPOWER2SUBn[i - 1] > 0) {
                    b[i] = SUMabDIV2[i - 1];
                } else {
                    b[i] = b[i - 1];
                }
                if (xPOWER2SUBn[i - 1] < 0) {
                    a[i] = SUMabDIV2[i - 1];
                } else {
                    a[i] = a[i - 1];
                }
                SUMabDIV2[i] = (a[i] + b[i]) / 2;
                xPOWER2SUBn[i] = SUMabDIV2[i] * SUMabDIV2[i] - root;
            }

            if (xPOWER2SUBn[i] < epsilon && xPOWER2SUBn[i] >= 0) {
                ansSum.add(SUMabDIV2[i]);
                ansxPOWER.add(xPOWER2SUBn[i]);
            }

            System.out.println("\t\t   " + a[i] + "\t\t   " + b[i] + "\t\t\t" + SUMabDIV2[i] + "\t\t\t"
                    + xPOWER2SUBn[i]);
        }
        System.out.println("คำตอบของ root " + root + " คือ " + max(ansSum)
                + " ที่ค่าใกล้เคียงกับ epsilon คือ" + max(ansxPOWER));
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("รากที่สองของ : ");
        float root = scan.nextFloat();
        System.out.print("ค่าเอปซีลอน : ");
        float epsilon = scan.nextFloat();
        System.out.println("\t\t\t ช่วงที่คัน \t\t\t\t" + "x = (a+b)/2 \t\t" + "x^2 - n");
        System.out.println("\t\t    a" + "\t\t   b");
        FindRoot findRoot = new FindRoot();
        findRoot.InputData(root, epsilon);
    }
}
