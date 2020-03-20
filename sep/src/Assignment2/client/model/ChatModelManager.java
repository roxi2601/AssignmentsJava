package Assignment2.client.model;

import Assignment2.client.network.SocketClient;
import Assignment2.server.network.SocketHandler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ChatModelManager implements ChatModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private SocketClient client;
  private SocketHandler handler;
  private String username;

  public ChatModelManager(SocketClient client) throws IOException
  {
    this.client = client;

    client.startClient();
    client.getHandler().addListener("NewMessage",this::onNewMessage);
  }
  private void onNewMessage(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }
  public void sendMessage(String message) throws IOException
  {
    System.out.println("model tells client to send "+message);
    client.sendMessage(message);
  }

  @Override public void saveUsername(String username)
  {
    this.username = username;
  }

  public String getUsername()
  {
    return username;
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
