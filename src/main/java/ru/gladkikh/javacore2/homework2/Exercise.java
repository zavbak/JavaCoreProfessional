package ru.gladkikh.javacore2.homework2;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise {


    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            //http://mydesignstudio.ru/2016/01/15/apache-maven-sqlite-dependency/
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
