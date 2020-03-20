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
            ServerSocket welcomeSocket = new ServerSocket(2222);
            ConnectionPool pool = new ConnectionPool();

            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("connection established");
                SocketHandler handler = new SocketHandler(socket,pool,textManagerModel);
                pool.addConnection(handler);
                new Thread(handler).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
