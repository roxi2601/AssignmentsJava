package Assignment2.client.views.chat;

import Assignment2.client.model.ChatModel;
import javafx.beans.property.StringProperty;

public class ChatViewModel {

  private StringProperty chatArea, sendField;
  private ChatModel model;

  public ChatViewModel(ChatModel chatModel)
  {
    model = chatModel;


  }

}
