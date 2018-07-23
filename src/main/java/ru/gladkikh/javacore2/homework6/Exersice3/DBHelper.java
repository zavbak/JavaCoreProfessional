package ru.gladkikh.javacore2.homework6.Exersice3;

import java.io.Closeable;
import java.io.File;
import java.sql.*;


public class DBHelper implements Closeable{
    private static DBHelper instance;

    private static final String URL = "jdbc:sqlite:" +
            System.getProperty("user.dir") + File.separator +
            "SQLite" + File.separator + "mybase.sqlite";

    private final Connection connection;
    private final PreparedStatement insertSt;
    private final PreparedStatement getByFamily;
    private final PreparedStatement dellByFamily;
    private final PreparedStatement updateByFamily;


    public static synchronized DBHelper getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    private DBHelper() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL);
        insertSt     = connection.prepareStatement("INSERT INTO studets(family, bal) VALUES(?,?);");
        getByFamily  = connection.prepareStatement("SELECT * FROM studets WHERE family = ?;");
        dellByFamily = connection.prepareStatement("DELETE FROM studets WHERE family = ?;");
        updateByFamily = connection.prepareStatement("UPDATE studets SET bal = ? WHERE family = ?;");
    }

    public void add(String family,int bal) throws SQLException {
         insertSt.setString(1,family);
         insertSt.setInt(2,bal);
         insertSt.execute();
    }

    public ResultSet getByFamily(String family) throws SQLException {
        getByFamily.setString(1,family);
        return getByFamily.executeQuery();
    }

    public void delete(String family) throws SQLException {
        dellByFamily.setString(1,family);
        dellByFamily.execute();
    }

    public void updateByFamily(String family, int bal) throws SQLException {
        updateByFamily.setString(2,family);
        updateByFamily.setInt(1,bal);
        dellByFamily.executeUpdate();
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
