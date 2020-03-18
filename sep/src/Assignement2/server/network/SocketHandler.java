package Assignement2.server.network;

import Assignement2.server.model.TextManager;
import Assignement2.server.model.TextManagerInt;
import Assignement2.shared.transferobjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable{
    private Socket socket;
    private TextManagerInt textManagerInt;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    public SocketHandler(Socket socket, TextManagerInt textManagerInt)
    {
        this.socket=socket;
        this.textManagerInt=textManagerInt;

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

                Request request=(Request) inFromClient.readObject();
            }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    private void onNewLogEntry(PropertyChangeEvent evt) {
        try {
            outToClient.writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
