package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

// Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.
public class HomeWork {
    public static void main(String[] args) throws IOException {
//        taskOne();
//        taskTwo();
//        taskThree();
    }

    private static void taskThree() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pageNumber = Integer.parseInt(reader.readLine());
        long t = System.currentTimeMillis();
        try (RandomAccessFile raf = new RandomAccessFile("text/test6.txt", "r")) {
            int startReading = (pageNumber - 1) * 1800;
            for (int i = 0; i < 1800; i++) {
                raf.seek(startReading + i);
                System.out.print((char) raf.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t));
    }

    private static void taskTwo() throws FileNotFoundException {
        ArrayList<InputStream> list = new ArrayList<>();
        list.add(new FileInputStream("text/test.txt"));
        list.add(new FileInputStream("text/test2.txt"));
        list.add(new FileInputStream("text/test3.txt"));
        list.add(new FileInputStream("text/test4.txt"));
        list.add(new FileInputStream("text/test5.txt"));
        Enumeration<InputStream> en = (Collections.enumeration(list));
    }

    private static void taskOne() {
        try (FileInputStream inputStream = new FileInputStream("text/test2.txt")) {
            byte[] arr = new byte[100];
            int x;
            while ((x = inputStream.read(arr)) > 0) {
                System.out.println(new String(arr, 0, x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
