package entity;

import main.Main;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class AssignmentTable implements Comparable<AssignmentTable>, Serializable {
    private Driver driver;
    private LinkedList<Assignment> assignments;

    public AssignmentTable(Driver driver, LinkedList<Assignment> assignments) {
        this.driver = driver;
        this.assignments = assignments;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LinkedList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(LinkedList<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "AssignmentTable{" +
                "driver=" + driver +
                ", assignments=" + assignments +
                '}';
    }

    public int compareTo(AssignmentTable assignmentTable) {
        return this.getDriver().getFullName().compareTo(assignmentTable.getDriver().getFullName());
    }

    public int getDistance() {
        if (isEmptyOrNull(assignments.toArray())) {
            return 0;
        }
        int sum = 0;
        for (Assignment assignment : assignments) {
            sum +=assignment.getQuantity()*assignment.getGland().getDistance();
        }
        return sum;
    }

    public static boolean isEmptyOrNull(Object[] obj) {
        return obj.length == 0 && obj == null;
    }
}