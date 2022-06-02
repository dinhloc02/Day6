package entity;

import impl.InfoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver extends Info {
    private int id;
    private static int autoId = 10000;
    private String level;
    public static final String LA = " Loại A";
    public static final String LB = " Loại B";
    public static final String LC = " Loại C";
    public static final String LD = " Loại D";
    public static final String LE = " Loại E";
    public static final String LF = " Loại F";

    public int getId() {
        return id;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void inputInfo() {
        this.id = autoId++;
        System.out.println("Mã lái xe là :" + this.getId());
        super.inputInfo();
        System.out.println("Trình độ người lái xe là :(1.Loại A , 2.Loại B , 3.Loại C ,4.Loại D , 5.Loại E , 6.Loại F)");
        int types =0;
        do {
            try {
                types = new Scanner(System.in).nextInt();
                if (types > 0 && types < 6) {
                    break;
                }
                System.out.println("Trình độ phải chọn từ 1 đến 6 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Trình độ phải chọn từ 1 đến 6 nhập lại:");
            }
        } while (true);
        switch (types){
            case 1:this.setLevel(Driver.LA);
            case 2:this.setLevel(Driver.LB);
            case 3:this.setLevel(Driver.LC);
            case 4:this.setLevel(Driver.LD);
            case 5:this.setLevel(Driver.LE);
            case 6:this.setLevel(Driver.LF);
        }
    }


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", level='" + level + '\'' +
                "} " + super.toString();
    }
}
