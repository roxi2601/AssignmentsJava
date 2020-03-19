package Assignment2.client.core;

import Assignment2.client.model.ChatModel;
import Assignment2.client.model.ChatModelManager;
import Assignment2.client.network.SocketClient;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class ModelFactory {
  private final ClientFactory cf;
  private ChatModel chatModel;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public ChatModel getChatModel() throws IOException
  {
    if(chatModel==null)
      chatModel = new ChatModelManager((SocketClient)cf.getClient());
      return chatModel;
  }
}
