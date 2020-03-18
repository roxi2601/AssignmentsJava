package Assignement2.client.model;

import Assignement2.client.network.SocketClient;
import Assignement2.server.network.SocketHandler;
import Assignement2.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ChatModelManager implements ChatModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private SocketClient client;
  private SocketHandler handler;

  public ChatModelManager(SocketClient client) throws IOException
  {
    this.client = client;

    client.startClient();
    client.getHandler().addListener("NewMessage",this::receiveMessage);
  }
  /*private void onNewMessage(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }*/
  public void sendMessage(String message) throws IOException
  {
    client.sendMessage(message);
  }
  @Override
  public String receiveMessage(PropertyChangeEvent evt)
  {
    return (String)evt.getNewValue();
  }
}
