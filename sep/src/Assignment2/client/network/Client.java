package Assignment2.client.network;

import Assignment2.shared.util.Subject;

import java.io.IOException;

public interface Client extends Subject
{
  //String getUsername();
  //void sendMessage(String text);
  void messageReceived(String str);
  void startClient() throws IOException;
}
