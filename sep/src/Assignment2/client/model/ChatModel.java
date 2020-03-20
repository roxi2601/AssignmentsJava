package Assignment2.client.model;

import Assignment2.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public interface ChatModel extends Subject
{
  void sendMessage(String message) throws IOException;
  void saveUsername(String username);
  String getUsername();
}
