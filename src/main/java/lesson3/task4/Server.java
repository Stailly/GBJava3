package lesson3.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket server;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            socket = server.accept();
            ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream serializer = new ObjectOutputStream(socket.getOutputStream());

            Cat cat = (Cat) deserializer.readObject();
            cat.printInfo();
        } catch (IOException | ClassNotFoundException e) {
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
