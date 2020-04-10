import java.util.Random;
import java.util.Scanner;

// Класс потоков
class ThreadControl implements Runnable {

    public Thread thread;
    private String threadName;

    ThreadControl(String name) {
        threadName = name;
        System.out.println("Поток " + threadName + " создан.");
    }
    @Override
    public void run() {
        Random rand = new Random();
        int randomNum = rand.nextInt((1000 - 100) + 1) + 10;
        try {
            Thread.sleep(randomNum);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + threadName + " остановлен");
        System.out.println("Время работы потока " + randomNum);
    }

    public void start() {
        System.out.println("Поток " + threadName + " запущен");
        thread = new Thread(this, threadName);
        thread.start();
    }
}
public class Program {

    // Главная процедура
    public static void main(String args[]) {
        System.out.println("Главный поток запущен.\n");
        createThreads();
        userChoice();
        System.out.println("Главный поток завершен.");
    }

    // Cоздание потоков
    public static void createThreads() {
        ThreadControl thread1 = new ThreadControl("1");
        thread1.start();
        ThreadControl thread2 = new ThreadControl("2");
        thread2.start();
        ThreadControl thread3 = new ThreadControl("3");
        thread3.start();
        ThreadControl thread4 = new ThreadControl("4");
        thread4.start();
        ThreadControl thread5 = new ThreadControl("5");
        thread5.start();
        System.out.println("\n");

        try {
            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
            thread4.thread.join();
            thread5.thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    // Выбор дальнейших действий
    public static void userChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Повтороить - 0; Выйти - 1");
        int choice = input.nextInt();
        if (choice == 0) {
            createThreads();
            userChoice();
        }
        else if (choice == 1) {
            System.out.println("Работа с потоками закончена.");
        }
        else
        {
            System.out.println("Неккоректный ввод. Повторите.\n");
            userChoice();
        }
    }
}
