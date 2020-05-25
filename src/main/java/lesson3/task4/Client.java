package lesson3.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            Cat cat = new Cat("Кот", 3);
            serializer.writeObject(cat);
            serializer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert socket != null;
        disconnect(socket);
    }

    private static void disconnect(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
