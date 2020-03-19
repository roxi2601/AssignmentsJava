package Assignment2.client.network;

import Assignment2.shared.transferobjects.Message;
import Assignment2.shared.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable, Subject
{
  private SocketClient client;
  private Socket socket;
  private ObjectOutputStream outToServer;
  private ObjectInputStream inFromServer;
  PropertyChangeSupport support = new PropertyChangeSupport(this);


  public ClientHandler(Socket socket, SocketClient client)
      throws IOException
  {
    this.socket = socket;
    this.client = client;

    outToServer = new ObjectOutputStream(socket.getOutputStream());
    inFromServer = new ObjectInputStream(socket.getInputStream());
  }
  @Override
  public void run()
  {
      try
      {
        outToServer.writeObject(new Message("Listener"));
        while (true)
        {
            Message message = new Message( inFromServer.readObject());
            support.firePropertyChange("NewMessage",null,message.getArg());
            //client.messageReceived((String) message.getArg());
        }
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  public void sendMessage(String msg) throws IOException
  {
    System.out.println("handler trying to send to server "+msg);
    outToServer.writeObject(new Message(msg));
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
