package ru.gladkikh.javacore2.homework2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    DBHelper dbHelper;

    public Controller(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void printResult(ResultSet result) throws SQLException {
        System.out.println("Результат...");
        while (result.next()) {
            System.out.println(

                    result.getInt("id") + " " +
                            result.getString("prodid") + " " +
                            result.getString("title") + " " +
                            result.getFloat("cost")
            );

        }
    }

    public void runCommand(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 0) {
            System.out.println("Не верная комманда...");
        } else {
            try {
                switch (arr[0]) {
                    case "/цена":
                        printResult(dbHelper.getByTitle(arr[1]));
                        break;
                    case "/сменитьцену":
                        dbHelper.updateCoast(arr[1],Float.parseFloat(arr[2]));
                        printResult(dbHelper.getByTitle(arr[1]));
                        break;
                    case "/товарыпоцене":
                        printResult(dbHelper.getCoastBetween(Float.parseFloat(arr[1]),Float.parseFloat(arr[2])));
                        break;
                    case "/выход":
                        System.out.println(arr[0]);
                        Thread.currentThread().interrupt();
                        break;
                    default:
                        System.out.println("Не верная комманда..");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
