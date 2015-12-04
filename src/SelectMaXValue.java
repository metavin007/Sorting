
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeMath.max;

/**
 *
 * @author User
 */
public class SelectMaXValue {

    public void createListProduct(int productamount) {

        Scanner scan = new Scanner(System.in);

        int productvalue[] = new int[productamount];
        float weight[] = new float[productamount];
        float price[] = new float[productamount];
        float averagesum[] = new float[productamount];
//================================================================= ใส่ input
        for (int i = 0; i <= productamount - 1; i++) {
            productvalue[i] = i + 1;
            System.out.print("น้ำหนักสินค้าชิ้นที่ " + productvalue[i] + " = ");
            weight[i] = scan.nextFloat();
            System.out.print("ราคาสินค้าชิ้นที่ " + productvalue[i] + " = ");
            price[i] = scan.nextFloat();
            averagesum[i] = price[i] / weight[i];

        }
//================================================================= ใส่ input 

//================================================================= ใส่ โชตาราง input
        System.out.println("");
        System.out.print("" + "\t\t");
        for (int i = 0; i <= productamount - 1; i++) {
            System.out.print("ชินที่ " + productvalue[i] + "\t\t");
        }
        System.out.println();
        System.out.print("น้ำหนัก" + "\t\t");
        for (int i = 0; i <= productamount - 1; i++) {
            System.out.print(weight[i] + "\t\t");
        }
        System.out.println();
        System.out.print("ราคา" + "\t\t");
        for (int i = 0; i <= productamount - 1; i++) {
            System.out.print(price[i] + "\t\t");
        }
        System.out.println();
        System.out.print("ราคา/น้ำหนัก" + "\t");
        for (int i = 0; i <= productamount - 1; i++) {
            System.out.print(averagesum[i] + "\t\t");
        }

//================================================================= โชตาราง input
        System.out.println();
        System.out.println();
        System.out.print("ค่าน้ำหนักที่ต้องการ : ");
        float weightwent = scan.nextFloat();
// ================================================== การหยิบ =====================================================
        float temp = 0;
        for (int i = 0; i < productamount - 1; i++) {
            for (int j = 1; j < productamount - 1; j++) {
                if (averagesum[j] > averagesum[j - 1]) {

                    temp = averagesum[j];
                    averagesum[j] = averagesum[j - 1];
                    averagesum[j - 1] = temp;

                    temp = productvalue[j];
                    productvalue[j] = productvalue[j - 1];
                    productvalue[j - 1] = (int) temp;

                    temp = weight[j];
                    weight[j] = weight[j - 1];
                    weight[j - 1] = temp;

                    temp = price[j];
                    price[j] = price[j - 1];
                    price[j - 1] = temp;
                }
            }
        }

        float sumweight = 0;
        float sumPrice = 0;

        System.out.println("\n\n \t\t\t ทำกการหยิบ \n");
        System.out.print("" + "\t\t");

        for (int i = 0; i <= productamount - 1; i++) {
            sumweight = sumweight + weight[i];
            if (weightwent - sumweight >= 0) {
                System.out.print("ชินที่ " + productvalue[i] + "\t\t");
            }
            if (weightwent - sumweight < 0) {
                sumweight = sumweight - weight[i];
            }
        }
        sumweight = 0;

        System.out.println();
        System.out.print("น้ำหนัก" + "\t\t");
        for (int i = 0; i <= productamount - 1; i++) {
            sumweight = sumweight + weight[i];
            if (weightwent - sumweight >= 0) {
                System.out.print(weight[i] + "\t\t");
            }
            if (weightwent - sumweight < 0) {
                sumweight = sumweight - weight[i];
            }
        }
        sumweight = 0;

        System.out.println();
        System.out.print("ราคา" + "\t\t");
        for (int i = 0; i <= productamount - 1; i++) {
            sumweight = sumweight + weight[i];
            if (weightwent - sumweight >= 0) {
                System.out.print(price[i] + "\t\t");
                sumPrice = sumPrice + price[i];
            }
            if (weightwent - sumweight < 0) {
                sumweight = sumweight - weight[i];
            }
        }
        sumweight = 0;

        System.out.println();
        System.out.print("ราคา/น้ำหนัก" + "\t");
        for (int i = 0; i <= productamount - 1; i++) {
            sumweight = sumweight + weight[i];
            if (weightwent - sumweight >= 0) {
                System.out.print(averagesum[i] + "\t\t");
            }
            if (weightwent - sumweight < 0) {
                sumweight = sumweight - weight[i];
            }
        }

        System.out.println("\n");
        System.out.println("น้ำหนักรวม : " + sumweight);
        System.out.println("มูลค่ารวม : " + sumPrice);

    }

// ================================================== การหยิบ =====================================================
    public static void main(String[] args) {
        SelectMaXValue run = new SelectMaXValue();
        Scanner scan = new Scanner(System.in);
        System.out.print("จำนวนสินค้าทั้งหมด = ");
        int productamount = scan.nextInt();
        run.createListProduct(productamount);
    }
}
