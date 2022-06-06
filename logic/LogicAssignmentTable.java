package logic;

import entity.Assignment;
import entity.AssignmentTable;
import entity.Driver;
import entity.Gland;
import main.Main;
import util.FileUtil;

import java.util.*;

public class LogicAssignmentTable {
    public static void addInfo() {


    }

    public static Driver inputDriver() {
        System.out.println("Nhập mã người lái xe cần phân công:");
        int idDriver = 0;
        Driver driver = null;
        do {
            do {
                try {
                    idDriver = new Scanner(System.in).nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Mã người lái xe phải là số nguyên nhập lại:");
                }
            } while (true);
            for (Driver driver1 : Main.drivers) {
                if (driver1.getId() == idDriver) {
                    driver = driver1;
                    break;
                }
            }
            if (driver != null) {
                break;
            }
            System.out.println("không có mã người lái xe nhập lại");
        } while (true);
        return driver;
    }

    public static List<Assignment> inputAssignment() {
        System.out.println("Nhập số lượng tuyến cần phân công");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0 && quantity < 16) {
                    break;
                }
                System.out.println("Số tuyến phân công không thể nhỏ hơn 1 và lớn hơn 15 nhập lại:");
            } catch (InputMismatchException e) {
                System.out.println("Số tuyến cần phân công  phải là số nguyên nhập lại:");
            }
        } while (true);
        Gland gland1 = null;
        List<Assignment> assignments = new LinkedList<>();
        for (int i = 0; i < quantity; ++i) {
            System.out.println("Nhập mã số tuyến cần phân công: ");
            int idGlands = 0;
            do {
                do {
                    try {
                        idGlands = new Scanner(System.in).nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Mã tuyến phải là số nguyên nhập lại:");
                    }
                } while (true);
                boolean check = true;
                for (Gland gland : Main.glands) {
                    for (Assignment assignment1 : assignments) {
                        if (assignment1 != null && assignment1.getGland().getId() == idGlands) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) {
                        break;
                    }
                    if (gland.getId() == idGlands) {
                        gland1 = gland;
                        break;
                    }
                }
                if (gland1 != null) {
                    break;
                }
                System.out.println("Không có mã tuyến hoặc đã có mã tuyến nhập lại:");
            } while (true);
            System.out.println("Nhập số lượt cần phân công:");
            int number = 0;
            do {
                try {
                    number = new Scanner(System.in).nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Số lượt phải là số nguyên nhập lại:");
                }
            } while (true);

            Assignment assignment = new Assignment(gland1, number);

            assignments.add(assignment);

        }
        return assignments;
    }

    public static void inputAssignmentTalble() {
        if (LogicDriver.isempty()||LogicGland.isempty()) {
            System.out.println("Nhập người lái xe và tuyến trước");
            return;
        }
        System.out.println("Nhập số lượng lái xe cần phân công:");
        int quantity = 0;
        do {
            try {
                quantity = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Số lượt phải là số nguyên nhập lại:");
            }
        } while (true);
        boolean check = false;
        for (int i = 0; i < quantity; ++i) {
            Driver driver = inputDriver();
            for (AssignmentTable assignmentTable : Main.assignmentTables) {
                if (assignmentTable != null && driver.getId() == assignmentTable.getDriver().getId()) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("lái xe đã có trong danh sách .");
                continue;
            }
            List<Assignment> assignments = inputAssignment();
            if (numberTurn((LinkedList<Assignment>) assignments) > 15) {
                System.out.println("Số lượt lái xe không được vượt quá 15.");
                continue;
            }
            AssignmentTable assignmentTable = new AssignmentTable(driver, (LinkedList<Assignment>) assignments);

            Main.assignmentTables.add(assignmentTable);
            FileUtil.writeDataToFile(Main.assignmentTables, "file/asmdata.txt");
        }
        for (AssignmentTable assignmentTable : Main.assignmentTables) {
            System.out.println(assignmentTable);
        }

    }

    public static int numberTurn(LinkedList<Assignment> assignment) {
        int sum = 0;
        for (Assignment assignments : assignment) {
            sum += assignments.getQuantity();
        }
        return sum;
    }

    public static void sortAlbName() {
        Collections.sort(Main.assignmentTables);
        for (AssignmentTable assignmentTable : Main.assignmentTables) {
            System.out.println(assignmentTable);
        }
    }

    public static void sumDistance() {
        for (AssignmentTable assignmentTable : Main.assignmentTables) {
            System.out.println("Tổng khoảng cách của người " + assignmentTable.getDriver().getFullName() + "là:" + assignmentTable.getDistance());
        }
    }
}


