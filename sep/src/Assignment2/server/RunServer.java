package Assignment2.server;

import Assignment2.server.model.TextManager;

import Assignment2.server.network.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManager());
        ss.startServer();
    }
}
