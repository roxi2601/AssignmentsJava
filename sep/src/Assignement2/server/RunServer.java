package Assignement2.server;

import Assignement2.server.model.TextManager;

import Assignement2.server.network.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManager());
        ss.startServer();
    }
}
