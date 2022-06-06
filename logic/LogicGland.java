package logic;

import entity.Driver;
import entity.Gland;
import main.Main;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicGland {
    public static void addInfo() {
        System.out.println("Nhập số lượng tuyến cần thêm:");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("Số người tuyến phải lớn hơn 0 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số người tuyến phải là số nguyên nhập lại:");
            }
        } while (true);
        for (int i = 0; i < quantity; ++i) {
            Gland gland = new Gland();
            gland.inputInfo();
            Main.glands.add(gland);
            FileUtil.writeDataToFile(Main.glands,"glandsdata.txt");
            showInfo();
        }
    }

    public static void showInfo() {
        for (Gland gland : Main.glands) {
            System.out.println(gland);
        }
    }
    public static boolean isempty() {
        for (Gland gland:Main.glands) {
            if (gland != null) {
                return false;
            }
        }
        return true;
    }
}
