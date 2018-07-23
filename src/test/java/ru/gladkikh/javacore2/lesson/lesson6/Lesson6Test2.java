package ru.gladkikh.javacore2.lesson.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@Slf4j
@RunWith(Parameterized.class)
public class Lesson6Test2 {

    private int a;
    private int b;
    private int c;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {1, 1, 2},
                {2, 2, 4},
                {5, 5, 10},
                {4, 2, 6},
                {1, 3, 4},
                {6, -2, 4},
                {-1, 5, 4},
        });
    }

    public Lesson6Test2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void setUp() throws Exception {
        log.info(String.format("а = %s  b = %s c = %s",a,b,c));
    }

    @BeforeClass
    public static void beforeClass() {
        log.info("Start beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        log.info("Start afterClass");
    }

    @After
    public void tearDown() throws Exception {
        log.info("Start tearDown");
    }

    @Test
    public void getSix() throws Exception {
        log.info("Start getSix");
    }

    @Test(expected = ArithmeticException.class)
    public void getFive() throws Exception {
        log.info("Start getFive");
        throw  new ArithmeticException();
    }

}