package ru.gladkikh.javacore2.homework2;

import java.io.Closeable;
import java.io.File;
import java.sql.*;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class DBHelper implements Closeable{
    private static DBHelper instance;

    private static final String URL = "jdbc:sqlite:" +
            System.getProperty("user.dir") + File.separator +
            "SQLite" + File.separator + "mybase.sqlite";

    private final Connection connection;
    private final PreparedStatement getAllSt;
    private final PreparedStatement insertSt;
    private final PreparedStatement clearSt;
    private final PreparedStatement getByTitleSt;
    private final PreparedStatement setCoastSt;
    private final PreparedStatement getCoastbetweenSt;

    public static synchronized DBHelper getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    private DBHelper() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL);

        getAllSt     = connection.prepareStatement("SELECT * FROM products;");
        insertSt     = connection.prepareStatement("INSERT INTO products(prodid, title,cost) VALUES(?,?,?);");
        clearSt      = connection.prepareStatement("DELETE FROM products;");
        getByTitleSt = connection.prepareStatement("SELECT * FROM products WHERE title = ?;");
        setCoastSt   = connection.prepareStatement("UPDATE products SET cost = ? WHERE title = ?;");
        getCoastbetweenSt = connection.prepareStatement("SELECT * FROM products WHERE cost BETWEEN ? AND ?;");

    }

    public void addProducts(int quantity) throws SQLException {
        Random random = new Random();
        float min = 10f;
        float max = 20f;

        connection.setAutoCommit(false);

        IntStream.range(1, quantity)
                .forEach(value -> {
                    try {
                        insertSt.setString(1, UUID.randomUUID().toString());
                        insertSt.setString(2, "product" + value);

                        String coast = Float.toString(random.nextFloat() * (max - min) + min);
                        insertSt.setString(3, coast);
                        insertSt.addBatch();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

        insertSt.executeBatch();
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void clear() throws SQLException {
        clearSt.execute();
    }

    public ResultSet getAll() throws SQLException {
        return getAllSt.executeQuery();
    }

    public ResultSet getByTitle(String title) throws SQLException {
        getByTitleSt.setString(1,title);
        return getByTitleSt.executeQuery();
    }

    public int updateCoast(String title,float coast) throws SQLException {
        setCoastSt.setString(1,Float.toString(coast));
        setCoastSt.setString(2,title);
        return setCoastSt.executeUpdate();
    }

    public ResultSet getCoastBetween(float value1,float value2) throws SQLException {
        getCoastbetweenSt.setFloat(1,value1);
        getCoastbetweenSt.setFloat(2,value2);
        return getCoastbetweenSt.executeQuery();
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
