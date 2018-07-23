package ru.gladkikh.javacore2.homework6.Exersice3;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.fail;


@Slf4j
public class DBHelperTest {
    private final String myFamily = "#1234512345";
    DBHelper dbHelper;

    @Before
    public void setUp() throws Exception {
        dbHelper = DBHelper.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        dbHelper.delete(myFamily);
        dbHelper.close();
    }


    @Test
    public void add()  {
        try {
            dbHelper.add(myFamily, 100);
            ResultSet result = dbHelper.getByFamily(myFamily);
            int i = 0;
            while (result.next()) {
                i++;
            }

            if (i == 0) {
                fail();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void update() {
        try {
            dbHelper.add(myFamily, 100);
            dbHelper.updateByFamily(myFamily,200);
            ResultSet result = dbHelper.getByFamily(myFamily);
            int i = 0;
            while (result.next()) {
                if (result.getInt("bal") != 200){
                    fail();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void delete(){
        try {
            dbHelper.add(myFamily, 100);
            dbHelper.delete(myFamily);

            ResultSet result = dbHelper.getByFamily(myFamily);
            int i = 0;
            while (result.next()) {
                i++;
            }

            if (i != 0) {
                fail();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }

    }

}