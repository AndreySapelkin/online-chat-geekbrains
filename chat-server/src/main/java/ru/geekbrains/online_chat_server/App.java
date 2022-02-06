package ru.geekbrains.online_chat_server;


import ru.geekbrains.online_chat_server.auth.InMemoryAuthService;
import ru.geekbrains.online_chat_server.server.Server;

public class App {
    public static void main(String[] args) {
        new Server(new InMemoryAuthService()).start();
    }
}