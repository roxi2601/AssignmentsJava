package Assignment2.server.network;

import Assignment2.server.model.TextManagerModel;
import Assignment2.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable
{

    private Socket socket;
    private TextManagerModel textManagerModel;
    private ConnectionPool pool;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, ConnectionPool pool, TextManagerModel textManagerModel)
    {
        this.pool = pool;
        this.socket = socket;
        this.textManagerModel = textManagerModel;

        try
        {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override public void run()
    {
        while(true)
       {
        try
        {
            Message message = (Message) inFromClient.readObject();

            if ("Listener".equals(message.getArg()))
            {
                System.out.println("client slucha servera");
                textManagerModel.addListener("NewMessage", this::onNewMessage);
            }
            else
            {
                String msg = (String) message.getArg();
                System.out.println("server received message: " + msg);
                textManagerModel.sendMessage((String) message.getArg());
                pool.broadCastMessage((String) message.getArg());
            }
        }

        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
private void onNewMessage(PropertyChangeEvent evt)
{
    String msg = (String)evt.getNewValue();
    try
    {
        sendMessage(msg);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
    public void sendMessage(String message) throws IOException
    {
        outToClient.writeObject(message);
    }

}
