package ru.gladkikh.javacore2.homework5;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description + " сейчас в тонеле " + MainClass.SEMAPHORE_FOR_TUNEL.getQueueLength() + " машин!");

                MainClass.SEMAPHORE_FOR_TUNEL.acquire();

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description);

                MainClass.SEMAPHORE_FOR_TUNEL.release();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}