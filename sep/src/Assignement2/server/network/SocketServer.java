package Assignement2.server.network;

import Assignement2.server.model.TextManagerInt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private TextManagerInt textManagerInt;
    public SocketServer(TextManagerInt textManagerInt)
    {
        this.textManagerInt=textManagerInt;
    }
    public void startServer()
    {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while (true) {
                Socket socket = welcomeSocket.accept();
                new Thread(new SocketHandler(socket, textManagerInt)).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
