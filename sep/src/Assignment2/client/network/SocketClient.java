package Assignment2.client.network;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.Socket;

public class SocketClient implements Client
{
  private PropertyChangeSupport support= new PropertyChangeSupport(this);
  private ClientHandler handler;
  private Socket socket;

  private String message = "";

  public void startClient() throws IOException
  {
    socket = new Socket("localhost",2222);

    handler = new ClientHandler(socket,this);
    Thread thread = new Thread(handler);
    thread.setDaemon(true);
    thread.start();
  }
  public void sendMessage(String arg) throws IOException
  {
    handler.sendMessage(arg);
  }
  public ClientHandler getHandler()
  {
    return  handler;
  }
  public void messageReceived(String message)
  {
    String oldValue = this.message;
    this.message = message;
    support.firePropertyChange("NewMessage",oldValue,message);
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

