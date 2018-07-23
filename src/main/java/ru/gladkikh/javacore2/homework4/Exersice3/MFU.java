package ru.gladkikh.javacore2.homework4.Exersice3;

public class MFU {
    private int countPrint;
    private int countScan;

    PrintTread printTread;
    ScanTread scanTread;

    public MFU() {
        countPrint = 0;
        countScan = 0;

        printTread = new PrintTread();
        scanTread = new ScanTread();
    }

    public void start() {
        printTread.start();
        scanTread.start();
        System.out.println("Start MFU");
    }

    public void stop() {
        printTread.interrupt();
        scanTread.interrupt();
        System.out.println("Stop MFU");
    }

    public synchronized void print() {
        countPrint++;
        printTread.print();
    }

    public synchronized void scan() {
        countScan++;
        scanTread.scan();
    }

    class PrintTread extends Thread {
        private Boolean print;

        public PrintTread() {
            print = false;
        }

        public void run() {
            while (!isInterrupted()) {
                if (print) {
                    System.out.println("Напечатано " + countPrint + " Страниц");
                    print = false;
                }
            }
        }

        public void print() {
            print = true;
        }

    }


    class ScanTread extends Thread {
        private Boolean scan;

        public ScanTread() {
            scan = false;
        }

        public void run() {
            while (!isInterrupted()) {
                if (scan) {
                    System.out.println("Сканировано " + countScan + " Страниц");
                    scan = false;
                }
            }
        }

        public void scan() {
            scan = true;
        }

    }

}
