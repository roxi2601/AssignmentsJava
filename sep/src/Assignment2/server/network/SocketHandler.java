package Assignment2.server.network;

import Assignment2.server.model.TextManagerModel;
import Assignment2.shared.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable{
    private Socket socket;
    private TextManagerModel textManagerModel;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    public SocketHandler(Socket socket, TextManagerModel textManagerModel)
    {
        this.socket=socket;
        this.textManagerModel = textManagerModel;

        try
        {
            outToClient=new ObjectOutputStream(socket.getOutputStream());
            inFromClient=new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void run() { //not finished
        try {

                Message message =(Message) inFromClient.readObject();
            }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    /*private void onNewLogEntry(PropertyChangeEvent evt) {
        try {
            outToClient.writeObject(new Message(evt.getPropertyName(), evt.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
