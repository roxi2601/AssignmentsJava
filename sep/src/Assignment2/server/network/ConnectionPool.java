package Assignment2.server.network;

import Assignment2.server.model.TextManager;
import Assignment2.server.model.TextManagerModel;
import Assignment2.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ConnectionPool
{
  private ArrayList<SocketHandler> connections = new ArrayList<>();

  public void addConnection(SocketHandler connection)
  {
    connections.add(connection);
  }
  public void removeConnection(SocketHandler connection)
  {
    connections.remove(connection);
  }

  public void broadCastMessage(String message) throws IOException
  {
    for (SocketHandler sh: connections)
    {
      sh.sendMessage(message);
    }
  }
}
