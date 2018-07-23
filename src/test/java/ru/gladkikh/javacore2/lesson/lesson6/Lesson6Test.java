package ru.gladkikh.javacore2.lesson.lesson6;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;

@Slf4j
public class Lesson6Test extends TestCase {
    @Before
    public void setUp() throws Exception {
        log.info("Strat setUp инициализацияы");
    }

    @After
    public void tearDown() throws Exception {
        log.info("Strat tearDown");
    }

    @AfterClass
    public static void after() {
        log.info("Strat after");
    }

    @BeforeClass
    public static void before() {
        log.info("Strat before");
    }

    @Test
    public void testGetSix() throws Exception {
        log.info("Strat testGetSix");
        Lesson6 lesson6 = new Lesson6();
        assertEquals(lesson6.getSix(),6);
    }


    @Test
    public void testGetFive() throws Exception {
        log.info("Strat testGetFive");
        Lesson6 lesson6 = new Lesson6();
        assertEquals(lesson6.getFive(),5);
    }

}