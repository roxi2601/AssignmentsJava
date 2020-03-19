package Assignment2.server.network;

import Assignment2.server.model.TextManagerModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private TextManagerModel textManagerModel;
    public SocketServer(TextManagerModel textManagerModel)
    {
        this.textManagerModel = textManagerModel;
    }
    public void startServer()
    {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while (true) {
                Socket socket = welcomeSocket.accept();
                new Thread(new SocketHandler(socket, textManagerModel)).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
