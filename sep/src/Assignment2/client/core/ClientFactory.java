package Assignment2.client.core;

import Assignment2.client.network.Client;
import Assignment2.client.network.SocketClient;

public class ClientFactory {

  private Client client;

  public Client getClient()
  {
    if(client ==null)
    {
      client = new SocketClient();
    }
    return client;
  }

}
