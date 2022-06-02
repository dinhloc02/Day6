package logic;

import com.sun.org.apache.bcel.internal.generic.DREM;
import entity.Driver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicDriver {
    public static void addInfo() {
        System.out.println("Nhập số lượng lái xe cần thêm:");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("Số người lái xe phải lớn hơn 0 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số người lái xe phải là số nguyên nhập lại:");
            }
        } while (true);
        for (int i = 0; i < quantity; ++i) {
            Driver driver = new Driver();

        }
    }
    public static void saveInfo(){
        for(int i=0;i<)
    }
}
