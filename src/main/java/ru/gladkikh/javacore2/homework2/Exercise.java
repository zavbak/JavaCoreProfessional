package ru.gladkikh.javacore2.homework2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        try (DBHelper dbHelper = DBHelper.getInstance()) {
            Controller controller = new Controller(dbHelper);

            while (!Thread.interrupted()) {
                Scanner scan = new Scanner(System.in);
                String s = scan.nextLine();
                controller.runCommand(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
