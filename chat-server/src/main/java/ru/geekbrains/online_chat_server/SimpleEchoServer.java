package ru.geekbrains.online_chat_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try (var serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started");

            var socket = serverSocket.accept();
            System.out.println("Client connected");

            var in = new DataInputStream(socket.getInputStream());
            var out = new DataOutputStream(socket.getOutputStream());

            while (true){
                var message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Echo: " + message);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
