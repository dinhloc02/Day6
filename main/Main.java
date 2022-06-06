package main;

import entity.Assignment;
import entity.AssignmentTable;
import entity.Gland;
import entity.Driver;
import logic.LogicDriver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static LinkedList<Driver> drivers = new LinkedList<>();
    public static LinkedList<Gland> glands = new LinkedList<>();
    public static LinkedList<AssignmentTable> assignmentTables = new LinkedList<>();

    public static void main(String[] args) {
      MainLogic.menu();
    }
}
